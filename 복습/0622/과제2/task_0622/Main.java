package com.example.spring.springtheory.ch01.task_0622;

public class Main {

    public static void main(String[] args) {

        // SRP
        System.out.println("===== SRP: 단일 책임 =====");
        Journal journal = new Journal();
        journal.add("오늘은 자바를 배웠다");
        journal.add("SOLID는 어렵지만 재밌다");
        JournalSaver saver = new JournalSaver();
        saver.print(journal);

        // OCP
        System.out.println();
        System.out.println("===== OCP: 개방-폐쇄 =====");
        DiscountPolicy[] policies = {
                new BasicDiscount(), new GoldDiscount(), new VipDiscount()
        };

        String[] grades = {
                "일반 회원", "골드 회원", "VIP 회원"
        };

        int price = 10000;
        for (int i = 0; i < policies.length; i++) {
            System.out.println(grades[i] + " -> " + policies[i].discount(price) + "원");
        }

        // LSP
        System.out.println();
        System.out.println("===== LSP: 리스코프 치환 =====");
        Bird[] birds = {
                new Sparrow(), new Penguin()
        };
        for (Bird bird : birds) {
            bird.eat();
        }

        Sparrow sparrow = new Sparrow();
        sparrow.fly();
        Penguin penguin = new Penguin();
        penguin.swim();

        // ISP
        System.out.println();
        System.out.println("===== ISP: 인터페이스 분리 =====");

        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print();

        SmartMachine smartMachine = new SmartMachine();
        smartMachine.print();
        smartMachine.scan();

        // DIP
        System.out.println();
        System.out.println("===== DIP: 의존관계 역전 =====");

        NotificationService emailService = new NotificationService(new EmailSender());
        NotificationService smsService = new NotificationService(new SmsSender());
        emailService.notifyUser("주문이 완료되었습니다");
        smsService.notifyUser("주문이 완료되었습니다");
    }
}
