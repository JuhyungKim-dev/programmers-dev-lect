import java.util.Scanner;

public class task2_0608 {
    // 자판기
    static final int COKE = 500, CIDER = 500, FANTA = 300, WATER = 200;
    public static void printMenu(int totalMoney) {
        System.out.println("=======자판기=======");
        System.out.println("[1]콜라 : 500, [2]사이다 : 500, [3]환타 : 300, [4]물 : 200, [5]돈 넣기, [6]종료");
        System.out.println("현재 금액 : " + totalMoney);
        System.out.println("=======자판기======");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 메뉴를 선택하세요.");
        return sc.nextInt();
    }

    public static int getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("돈을 넣어주세요");
        return sc.nextInt();
    }

    public static int calcMoney(int totalMoney, int price) {
        return totalMoney - price;
    }

    public static void calcMoneyException() {
            System.out.println("잔돈이 부족합니다.");
        }

    static void main() {
        int totalMoney = 0;
        while ( true ) {
            printMenu(totalMoney);
            int choice = getChoice();
            int result = -1;
            switch (choice) {
                case 1:
                    result = calcMoney(totalMoney, COKE);
                    if ( result < 0 ) {
                        calcMoneyException();
                    } else {
                        totalMoney = result;
                        System.out.println("콜라가 나왔습니다.");
                    }
                    break;
                case 2:
                    result = calcMoney(totalMoney, CIDER);
                    if ( result < 0 ) {
                        System.out.println("잔돈이 부족합니다.");
                    } else {
                        totalMoney = result;
                        System.out.println("사이다가 나왔습니다.");
                    }
                    break;
                case 3:
                    result = calcMoney(totalMoney, FANTA);
                    if ( result < 0 ) {
                        System.out.println("잔돈이 부족합니다.");
                    } else {
                        totalMoney = result;
                        System.out.println("환타가 나왔습니다.");
                    }
                    break;
                case 4:
                    result = calcMoney(totalMoney, WATER);
                    if ( result < 0 ) {
                        System.out.println("잔돈이 부족합니다.");
                    } else {
                        totalMoney = result;
                        System.out.println("믈이 나왔습니다.");
                    }
                    break;
                case 5:
                    totalMoney += getMoney();
                    break;
                case 6:
                    System.out.println("\n잔돈 " + totalMoney + "원이 반환되었습니다.");
                    return;
                default:
                    System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }


    // 회원관리프로그램
    static int totalCnt = 0;
    static int memberCnt = 0;

    public static int printPricePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[요금제를 선택하세요]");
        System.out.println("[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명");
        return sc.nextInt();
    }

    public static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[수행할 업무를 선택하세요 - 현재 회원수 : " + memberCnt + "/" + totalCnt  + "]");
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]회원전체조회 [5]회원정보 수정 [6]회원삭제");
        System.out.println("[7]프로그램 종료");
        return sc.nextInt();
    }

    public static void addMember(String[][] members) {
        if (memberCnt == totalCnt) {
            System.out.println("회원이 꽉찼습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력하세요.");
        String email = sc.nextLine();
        System.out.println("연락처를 입력하세요.");
        String phone = sc.nextLine();

        if ( checkEmail(members, email) ) {
            System.out.println("이미 존재하는 회원입니다.");
            return;
        }

        members[memberCnt][0] = name;
        members[memberCnt][1] = email;
        members[memberCnt][2] = phone;
        memberCnt++;
    }

    public static boolean checkEmail(String[][] members, String email) {
        for (int i = 0; i < members.length; i++) {
            if ( email.equals(members[i][1]) ) {
                return true;
            }
        }

        return false;
    }

    public static void selectEmail(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이메일을 입력하세요.");
        String email = sc.nextLine();

        for (int i = 0; i < members.length; i++) {
            if ( email.equals(members[i][1]) ) {
                System.out.println("[이름] " + members[i][0] + ", [메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                return;
            }
        }
        System.out.println("찾으시는 정보가 없습니다.");
    }

    public static void selectName(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이름을 입력하세요.");
        String name = sc.nextLine();

        for (int i = 0; i < members.length; i++) {
            if ( name.equals(members[i][0]) ) {
                System.out.println("[이름] " + members[i][0] + ", [메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                return;
            }
        }
        System.out.println("찾으시는 정보가 없습니다.");
    }

    public static void selectAll(String[][] members) {
        for (int i = 0; i < members.length; i++) {
            System.out.println("[이름] " + members[i][0] + ", [메일] " + members[i][1] + ", [연락처] " + members[i][2]);
        }
    }

    public static void updateMember(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[수정] 이메일을 입력하세요.");
        String email = sc.nextLine();
        int idx = -1;
        for (int i = 0; i < members.length; i++) {
            if ( email.equals(members[i][1]) ) {
                idx = i;
                break;
            }
        }

        if ( idx == -1 ) {
            System.out.println("찾으시는 회원이 없습니다.");
            return;
        }

        System.out.println("변경할 이름을 입력하세요.");
        String newName = sc.nextLine();
        System.out.println("변경할 이메일을 입력하세요.");
        String newEmail = sc.nextLine();
        System.out.println("변경할 연락처를 입력하세요.");
        String newPhone = sc.nextLine();

        members[idx][0] = newName;
        members[idx][1] = newEmail;
        members[idx][2] = newPhone;
        System.out.println("수정이 완료되었습니다.");
    }

    public static void deleteMember(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[삭제] 이메일을 입력하세요.");
        String email = sc.nextLine();
        int idx = -1;

        for (int i = 0; i < members.length; i++) {
            if ( email.equals(members[i][1]) ) {
                idx = i;
                break;
            }
        }

        if ( idx == -1 ) {
            System.out.println("찾으시는 회원이 없습니다.");
            return;
        }

        for (int i = idx; i < memberCnt-1; i++) {
            members[i][0] = members[i+1][0];
            members[i][1] = members[i+1][1];
            members[i][2] = members[i+1][2];
        }

        members[memberCnt-1][0] = null;
        members[memberCnt-1][1] = null;
        members[memberCnt-1][2] = null;
        memberCnt--;
    }

    static void main(String[] args) {

        int pricePlan = printPricePlan();
        totalCnt = pricePlan * 10;
        String[][] members = new String[totalCnt][3];
        System.out.println(totalCnt);

        while ( true ) {
            int menu = printMenu();
            System.out.println(menu);
            switch (menu) {
                case 1:
                    addMember(members);
                    break;
                case 2:
                    selectEmail(members);
                    break;
                case 3:
                    selectName(members);
                    break;
                case 4:
                    selectAll(members);
                    break;
                case 5:
                    updateMember(members);
                    break;
                case 6:
                    deleteMember(members);
                    break;
                case 7:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘 못 눌렀습니다.");
                    break;
            }
        }
    }
}
