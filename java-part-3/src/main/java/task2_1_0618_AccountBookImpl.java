
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class task2_1_0618_AccountBookImpl implements task2_1_0618_AccountBook {

    private final String DIR = "accountbook";
    private Scanner sc = new Scanner(System.in);

    public task2_1_0618_AccountBookImpl() {
        File folder = new File(DIR);
        if (!folder.exists()) {folder.mkdir();
        }
    }

    @Override
    public void addAccount() {
        String today = LocalDate.now().toString();
        File file = new File(DIR, today + ".txt");
        int total = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            System.out.print("항목 이름 > ");
            String item = sc.nextLine();
            int money;
            try {
                System.out.print("금액 > ");
                money = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요");
                continue;
            }
            sb.append(item).append(" : ").append(money).append("원\n");
            total += money;
            System.out.print("더 추가할까요? (y/n) > ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                break;
            }
        }
        sb.append("합계 : ").append(total).append("원\n");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(sb.toString());
            System.out.println("\n" + today + ".txt 에 저장 완료!");
            System.out.println(sb);
        } catch (IOException e) {
            System.out.println("저장 중 오류: " + e.getMessage());
        }
    }

    @Override
    public void showAccount() {
        File folder = new File(DIR);
        String[] files = folder.list();
        if (files == null || files.length == 0) {
            System.out.println("기록이 없습니다");
            return;
        }
        System.out.println("== 기록된 날짜 ==");
        for (String name : files) {
            if (name.endsWith(".txt")) {
                System.out.println(name.replace(".txt", ""));
            }
        }
        System.out.print("조회할 날짜 입력 > ");
        String date = sc.nextLine();
        File file = new File(DIR, date + ".txt");
        if (!file.exists()) {
            System.out.println("그런 날짜가 없습니다");
            return;
        }
        System.out.println("\n[" + date + "]");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("조회 중 오류: " + e.getMessage());
        }
    }

    @Override
    public void deleteAccount() {
        File folder = new File(DIR);
        String[] files = folder.list();
        if (files == null || files.length == 0) {
            System.out.println("기록이 없습니다");
            return;
        }
        System.out.println("== 기록된 날짜 ==");
        for (String name : files) {
            if (name.endsWith(".txt")) {
                System.out.println(name.replace(".txt", ""));
            }
        }
        System.out.print("삭제할 날짜 입력 > ");
        String date = sc.nextLine();
        File file = new File(DIR, date + ".txt");

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("삭제되었습니다");
            } else {
                System.out.println("삭제 실패");
            }
        } else {
            System.out.println("그런 날짜가 없습니다");
        }
    }
}