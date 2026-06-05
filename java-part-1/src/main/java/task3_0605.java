import java.util.Scanner;
import java.util.*;

public class task3_0605
{
    public static class Item {
        private String name;
        private int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    public static interface AccountBook {
        void addAccount();    // 1. 내역 추가
        void showAccount();   // 2. 내역 조회
        void deleteAll();     // 3. 전체 삭제
        void deleteItem();    // 4. 내역 삭제
    }

    public static class AccountBookImpl implements  AccountBook {
        private Map<String, List<Item>> data = new HashMap<>();
        private Scanner sc = new Scanner(System.in);

        public void addAccount()  { /* TODO Step 5 */
            System.out.println("날짜를 입력해주세요");
            int date = sc.nextInt();

        }
        public void showAccount() { /* TODO Step 6 */ }
        public void deleteAll()   { /* TODO Step 7 */ }
        public void deleteItem()  { /* TODO Step 8 */ }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountBook book = new AccountBookImpl();

        while (true) {
            System.out.println("===== 가계부 =====");
            System.out.println("1. 내역 추가");
            System.out.println("2. 내역 조회");
            System.out.println("3. 전체 삭제");
            System.out.println("4. 내역 삭제");
            System.out.println("5. 종료");
            System.out.println("번호 입력 > ");
            int menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:
                    book.addAccount();
                    break;
                case 2:
                    book.showAccount();
                    break;
                case 3:
                    book.deleteAll();
                    break;
                case 4:
                    book.deleteItem();
                    break;
                case 5:
                    System.out.println("종료합니다");
                    return;
                default:
                    System.out.println("잘못된 번호입니다");
                    break;
            }
        }
    }

}

