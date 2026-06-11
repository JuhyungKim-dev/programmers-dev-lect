import java.util.Scanner;

public class task2_0611_Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[1] Lite : 10명");
        System.out.println("[2] Basic : 20명");
        System.out.println("[3] Premium : 30명");
        System.out.print("> ");

        int plan = Integer.parseInt(sc.nextLine());
        task2_0611_MemberManager manager =
                new task2_0611_MemberManager(plan * 10);

        while (true) {
            System.out.println();
            System.out.println("[수행할 업무 - 현재 회원수 : " + manager.getCount() + "/" + manager.getCapacity() + "]");
            System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
            System.out.println("[4]전체조회 [5]수정 [6]삭제 [7]종료");
            System.out.print("> ");
            int menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1:
                    if (manager.isFull()) {
                        System.out.println("회원 정원이 가득 찼습니다.");
                        break;
                    }
                    System.out.println("[1]일반회원 [2]VIP회원");
                    System.out.print("> ");
                    int grade = Integer.parseInt(sc.nextLine());
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    System.out.print("이메일 : ");
                    String email = sc.nextLine();
                    System.out.print("연락처 : ");
                    String phone = sc.nextLine();
                    if (manager.existsEmail(email)) {
                        System.out.println("이미 존재하는 이메일입니다.");
                        break;
                    }
                    task2_0611_Member member;
                    if (grade == 2) {
                        member = new task2_0611_VipMember(name, email, phone);
                    } else {
                        member = new task2_0611_NormalMember(name, email, phone);
                    }
                    manager.add(member);
                    System.out.println("회원 등록 완료");
                    break;
                case 2:
                    System.out.print("이메일 : ");
                    email = sc.nextLine();
                    task2_0611_Member emailMember = manager.findByEmail(email);
                    if (emailMember == null) {
                        System.out.println("회원이 없습니다.");
                    } else {
                        emailMember.printInfo();
                    }
                    break;
                case 3:
                    System.out.print("이름 : ");
                    name = sc.nextLine();
                    task2_0611_Member nameMember = manager.findByName(name);
                    if (nameMember == null) {
                        System.out.println("회원이 없습니다.");
                    } else {
                        nameMember.printInfo();
                    }
                    break;
                case 4:
                    manager.printAll();
                    break;
                case 5:
                    System.out.print("수정할 회원 이메일 : ");
                    email = sc.nextLine();
                    System.out.print("새 이름 : ");
                    name = sc.nextLine();
                    System.out.print("새 이메일 : ");
                    String newEmail = sc.nextLine();
                    System.out.print("새 연락처 : ");
                    phone = sc.nextLine();
                    if (manager.update(email, name, newEmail, phone)) {
                        System.out.println("수정 완료");
                    } else {
                        System.out.println("회원이 없습니다.");
                    }
                    break;
                case 6:
                    System.out.print("삭제할 회원 이메일 : ");
                    email = sc.nextLine();
                    if (manager.delete(email)) {
                        System.out.println("삭제 완료");
                    } else {
                        System.out.println("회원이 없습니다.");
                    }
                    break;
                case 7:
                    System.out.println("프로그램 종료");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}