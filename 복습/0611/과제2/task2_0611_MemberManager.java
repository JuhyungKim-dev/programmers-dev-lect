public class task2_0611_MemberManager {

    private task2_0611_Member[] members;
    private int memberCnt;

    public task2_0611_MemberManager(int capacity) {
        members = new task2_0611_Member[capacity];
        memberCnt = 0;
    }

    public boolean isFull() {
        return memberCnt == members.length;
    }

    public int getCount() {
        return memberCnt;
    }

    public int getCapacity() {
        return members.length;
    }

    public boolean existsEmail(String email) {
        for (int i = 0; i < memberCnt; i++) {
            if (members[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void add(task2_0611_Member member) {
        members[memberCnt] = member;
        memberCnt++;
    }

    public task2_0611_Member findByEmail(String email) {
        for (int i = 0; i < memberCnt; i++) {
            if (members[i].getEmail().equals(email)) {
                return members[i];
            }
        }
        return null;
    }

    public task2_0611_Member findByName(String name) {

        for (int i = 0; i < memberCnt; i++) {
            if (members[i].getName().equals(name)) {
                return members[i];
            }
        }
        return null;
    }

    public void printAll() {
        if (memberCnt == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        for (int i = 0; i < memberCnt; i++) {
            members[i].printInfo();
        }
    }

    public boolean update(String email, String name, String newEmail, String phone) {
        task2_0611_Member member = findByEmail(email);
        if (member == null) {
            return false;
        }
        member.update(name, newEmail, phone);
        return true;
    }

    public boolean delete(String email) {
        int idx = -1;
        for (int i = 0; i < memberCnt; i++) {
            if (members[i].getEmail().equals(email)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return false;
        }
        for (int i = idx; i < memberCnt - 1; i++) {
            members[i] = members[i + 1];
        }
        members[memberCnt - 1] = null;
        memberCnt--;
        return true;
    }
}