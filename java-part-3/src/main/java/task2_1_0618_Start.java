
import java.util.Scanner;

public class task2_1_0618_Start {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        task2_1_0618_AccountBook book = new task2_1_0618_AccountBookImpl();

        while (true) {
            System.out.println("\n===== 가계부 (File) =====");
            System.out.println("1. 내역 추가");
            System.out.println("2. 내역 조회");
            System.out.println("3. 삭제");
            System.out.println("4. 종료");
            System.out.print("번호 입력 > ");
            int menu;
            try {
                menu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요");
                continue;
            }

            switch (menu) {
                case 1:
                    book.addAccount();
                    break;
                case 2:
                    book.showAccount();
                    break;
                case 3:
                    book.deleteAccount();
                    break;
                case 4:
                    System.out.println("종료합니다");
                    return;
                default:
                    System.out.println("잘못된 번호입니다");
            }
        }
    }
}