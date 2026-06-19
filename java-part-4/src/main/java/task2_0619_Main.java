
import java.util.Scanner;

public class task2_0619_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[1]Lite:10 [2]Basic:20 [3]Premium:30");

        task2_0619_PricePlan plan = null;

        while (plan == null) {
            plan = task2_0619_PricePlan.from(readInt(sc));

            if (plan == null) {
                System.out.println("1~3 중에서 선택하세요.");
            }
        }

        task2_0619_MemberManager manager =
                new task2_0619_MemberManager(plan.getCapacity());

        while (true) {
            System.out.println("\n[현재 " + manager.size() + "/" + manager.capacity() + "]");
            System.out.println("[1]추가 [2]메일조회 [3]이름조회 [4]전체 [5]수정 [6]삭제 [7]종료");

            int menu = readInt(sc);

            switch (menu) {

                case 1: {
                    if (manager.isFull()) {
                        System.out.println("정원이 찼습니다.");
                        break;
                    }

                    System.out.println("등급 [1]일반 [2]VIP");

                    int grade = readInt(sc);

                    System.out.print("이름 > ");
                    String name = sc.nextLine();

                    System.out.print("이메일 > ");
                    String email = sc.nextLine();

                    System.out.print("연락처 > ");
                    String phone = sc.nextLine();

                    if (manager.existsEmail(email)) {
                        System.out.println("이미 있는 회원입니다.");
                        break;
                    }

                    task2_0619_Member m;

                    if (grade == 2) {
                        m = new task2_0619_VipMember(name, email, phone);
                    } else {
                        m = new task2_0619_NormalMember(name, email, phone);
                    }

                    manager.add(m);

                    System.out.println("추가되었습니다.");

                    break;
                }

                case 2: {
                    System.out.print("이메일 > ");

                    String email = sc.nextLine();

                    task2_0619_Member m = manager.findByEmail(email);

                    if (m == null) {
                        System.out.println("회원이 없습니다.");
                    } else {
                        m.printInfo();
                    }

                    break;
                }

                case 3: {
                    System.out.print("이름 > ");

                    String name = sc.nextLine();

                    task2_0619_Member m = manager.findByName(name);

                    if (m == null) {
                        System.out.println("회원이 없습니다.");
                    } else {
                        m.printInfo();
                    }

                    break;
                }

                case 4: {
                    manager.printAll();
                    break;
                }

                case 5: {
                    System.out.print("수정할 이메일 > ");
                    String email = sc.nextLine();

                    System.out.print("새 이름 > ");
                    String name = sc.nextLine();

                    System.out.print("새 이메일 > ");
                    String newEmail = sc.nextLine();

                    System.out.print("새 연락처 > ");
                    String phone = sc.nextLine();

                    boolean result =
                            manager.update(email, name, newEmail, phone);

                    if (result) {
                        System.out.println("수정되었습니다.");
                    } else {
                        System.out.println("회원이 없습니다.");
                    }

                    break;
                }

                case 6: {
                    System.out.print("삭제할 이메일 > ");

                    String email = sc.nextLine();

                    boolean result = manager.delete(email);

                    if (result) {
                        System.out.println("삭제되었습니다.");
                    } else {
                        System.out.println("회원이 없습니다.");
                    }

                    break;
                }

                case 7: {
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                }

                default:
                    System.out.println("1~7 중에서 선택하세요.");
            }
        }
    }

    static int readInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}