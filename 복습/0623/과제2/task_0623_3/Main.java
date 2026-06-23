package com.example.spring.springtheory.ch01.task_0623_3;

public class Main {
    static int badMismatch = 0;
    static int goodMismatch = 0;

    public static void main(String[] args)
            throws InterruptedException {
        int N = 30;
        Thread[] badThreads = new Thread[N];
        for (int i = 0; i < N; i++) {
            final String myName = "손님" + i;
            badThreads[i] = new Thread(() -> {
                String result = GreetingServiceBad.getInstance().greet(myName);
                if (!result.equals(myName)) {
                    synchronized (Main.class) {
                        badMismatch++;
                    }
                }
            });
        }
        for (Thread t : badThreads) {
            t.start();
        }
        for (Thread t : badThreads) {
            t.join();
        }

        Thread[] goodThreads = new Thread[N];
        for (int i = 0; i < N; i++) {
            final String myName = "손님" + i;
            goodThreads[i] = new Thread(() -> {
                String result = GreetingServiceGood.getInstance().greet(myName);
                if (!result.equals(myName)) {
                    synchronized (Main.class) {
                        goodMismatch++;
                    }
                }
            });
        }
        for (Thread t : goodThreads) {
            t.start();
        }
        for (Thread t : goodThreads) {
            t.join();
        }

        System.out.println("===== 같은 싱글톤을 30개 스레드가 동시에 사용 =====");
        System.out.println("[필드에 저장] 데이터 엉킴: " + badMismatch + "건 / " + N + "건");
        System.out.println("[파라미터로]  데이터 엉킴: " + goodMismatch + "건 / " + N + "건");
        System.out.println();
        System.out.println("===== 필드에 둬도 되는 것: 다른 싱글톤 참조 =====");

        UserDao dao1 = UserDao.getInstance();
        UserDao dao2 = UserDao.getInstance();
        System.out.println(dao1.findUser("kim"));
        System.out.println(dao2.findUser("lee"));
        System.out.println("같은 DAO인가? " + (dao1 == dao2));
    }
}