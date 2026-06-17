import java.util.Scanner;

class PrintDash extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class PrintBar extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}

class SleepThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
        }
        System.out.println("\n<<SleepThread 종료>>");
    }
}

class CountThread extends Thread {
    @Override
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 2_500_000_000L; x++) {
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

class CountSleepThread extends Thread {

    @Override
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                System.out.println("자다가 깨어남! (InterruptedException)");
                break;
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

class YieldThread extends Thread {
    private String name;
    public YieldThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " 실행 중. 반복: " + i);
            Thread.yield();
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }
}

class ManyPrintThread extends Thread {
    private char ch;
    public ManyPrintThread(char ch) {
        this.ch = ch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(ch);
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
            }
        }
    }
}

public class task2_1_0617_Thread {
    public static void exam1() {

        PrintDash t1 = new PrintDash();
        PrintBar t2 = new PrintBar();
        t1.start();
        t2.start();
    }

    public static void exam2() {

        SleepThread t1 = new SleepThread();
        t1.start();
        try {
            t1.sleep(2000);
        }
        catch (InterruptedException e) {
        }
        System.out.println("\nmain 스레드 종료");
    }

    public static void exam3() {

        CountThread t1 = new CountThread();
        t1.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("엔터를 누르면 interrupt 요청");
        sc.nextLine();
        t1.interrupt();
        System.out.println("interrupt 요청 완료");
    }

    public static void exam4() {

        CountSleepThread t1 = new CountSleepThread();
        t1.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("엔터를 누르면 interrupt 요청");
        sc.nextLine();
        t1.interrupt();
    }

    public static void exam5() {

        YieldThread t1 = new YieldThread("스레드1");
        YieldThread t2 = new YieldThread("스레드2");
        t1.start();
        t2.start();
    }

    public static void exam6() {

        ManyPrintThread t1 = new ManyPrintThread('-');
        ManyPrintThread t2 = new ManyPrintThread('|');
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        System.out.println("\n소요시간: " + (end - start) + "ms");
    }

    public static void main(String[] args) {

        // exam1();
        // exam2();
        // exam3();
        // exam4();
        // exam5();
        exam6();
    }
}