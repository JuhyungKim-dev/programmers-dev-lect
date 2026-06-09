import java.util.Random;
import java.util.Scanner;

public class task2_0609 {
    public static void main(String[] args) {

        Random rand = new Random();
        int answer = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("숫자를 맞혀보세요! (1 ~ 100)");

        while (true) {
            System.out.print("입력 > ");
            int guess = sc.nextInt();
            if (guess < 1 || guess > 100) {
                System.out.println("1~100 사이로 입력해 주세요.");
                continue;
            }
            count++;

            if (guess == answer) {
                System.out.println("정답입니다! " + count + "번 만에 맞혔어요.");
                break;
            } else if (guess < answer) {
                System.out.println("UP! 더 큰 수입니다.");
            } else {
                System.out.println("DOWN! 더 작은 수입니다.");
            }
        }
        sc.close();
    }
}
