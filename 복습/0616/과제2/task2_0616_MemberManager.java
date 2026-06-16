import java.util.ArrayList;
import java.util.List;

public class task2_0616_MemberManager {
    private final List<task2_0616_Member> members = new ArrayList<>();
    private final int capacity;
    public task2_0616_MemberManager(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return members.size() >= capacity;
    }

    public boolean existsEmail(String email) {
        for (task2_0616_Member m : members) {
            if (m.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void add(task2_0616_Member m) {
        members.add(m);
    }

    public int size() {
        return members.size();
    }

    public int capacity() {
        return capacity;
    }

    public task2_0616_Member findByEmail(String email) {
        for (task2_0616_Member m : members) {
            if (m.getEmail().equals(email)) {
                return m;
            }
        }
        return null;
    }

    public task2_0616_Member findByName(String name) {
        for (task2_0616_Member m : members) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public void printAll() {
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        for (task2_0616_Member m : members) {
            m.printInfo();
        }
    }

    public boolean update(String email, String name, String newEmail, String phone) {
        task2_0616_Member m = findByEmail(email);
        if (m == null) {
            return false;
        }
        m.update(name, newEmail, phone);
        return true;
    }

    public boolean delete(String email) {
        task2_0616_Member m = findByEmail(email);
        if (m == null) {
            return false;
        }
        members.remove(m);
        return true;
    }
}