import java.util.Scanner;

public class task3_0604 {

    static final int COKE = 500, CIDER = 700, FANTA = 300, WATER = 200;

    public static void printMenu(int totalMoney) {
        System.out.println("================================= 자판기 ================================");
        System.out.println("[1]콜라-500원 [2]사이다-700원 [3]환타-300원 [4]물-200원 [5]돈넣기 [6]종료");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {

        int totalMoney = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu(totalMoney);
            System.out.println("메뉴를 골라주세요");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.println("콜라는 500원입니다. 수량을 선택해주세요");
                int count = sc.nextInt();
                if (totalMoney >= count * 500) {
                    System.out.println("구매가 완료되었습니다");
                    totalMoney = totalMoney - (count * 500);
                } else {
                    System.out.println("금액이 부족합니다.");
                }

            } else if (menu == 2) {
                System.out.println("사이다는 700원입니다. 수량을 선택해주세요");
                int count = sc.nextInt();
                if (totalMoney >= count * 700) {
                    System.out.println("구매가 완료되었습니다");
                    totalMoney = totalMoney - (count * 700);
                } else {
                    System.out.println("금액이 부족합니다.");
                }

            } else if (menu == 3) {
                System.out.println("환타는 300원입니다. 수량을 선택해주세요");
                int count = sc.nextInt();
                if (totalMoney >= count * 300) {
                    System.out.println("구매가 완료되었습니다");
                    totalMoney = totalMoney - (count * 300);
                } else {
                    System.out.println("금액이 부족합니다.");
                }

            } else if (menu == 4) {
                System.out.println("물은 200원입니다. 수량을 선택해주세요");
                int count = sc.nextInt();
                if (totalMoney >= count * 200) {
                    System.out.println("구매가 완료되었습니다");
                    totalMoney = totalMoney - (count * 200);
                } else {
                    System.out.println("금액이 부족합니다.");
                }

            } else if (menu == 5) {
                System.out.println("입금할 금액을 선택해주세요");
                int Money = sc.nextInt();
                if (Money >= 0) {
                    System.out.println("입금되었습니다");
                    totalMoney = Money;
                } else {
                    System.out.println("금액을 다시 넣어주세요");
                }
            } else if (menu == 6) {
                System.out.println("종료되었습니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}
