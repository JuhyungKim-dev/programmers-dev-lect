package com.example.spring.springtheory.ch05.task_0630;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Part A =====");
        NotificationService emailService = new NotificationService(new EmailNotificationSender());
        emailService.notifyUser("user@test.com", "이메일 알림");
        NotificationService smsService = new NotificationService(new SmsNotificationSender());
        smsService.notifyUser("010-1111-2222", "문자 알림");
        NotificationService kakaoService = new NotificationService(new KakaoNotificationSender());
        kakaoService.notifyUser("카카오 사용자", "카카오톡 알림");
        System.out.println();
        System.out.println("===== Part C =====");
        NotificationSender sender = new TimingNotificationSender(new LoggingNotificationSender
                (new RetryNotificationSender(new FlakyEmailSender())));
        NotificationService service = new NotificationService(sender);
        service.notifyUser("user@test.com", "안녕하세요");

        System.out.println();
        System.out.println("===== 순서 변경 실험 =====");
        System.out.println("----- Logging(Retry()) -----");
        NotificationSender sender1 = new LoggingNotificationSender(new RetryNotificationSender
                (new FlakyEmailSender()));
        new NotificationService(sender1).notifyUser("user@test.com", "테스트");

        System.out.println();
        System.out.println("----- Retry(Logging()) -----");
        NotificationSender sender2 = new RetryNotificationSender(new LoggingNotificationSender(
                new FlakyEmailSender()));
        new NotificationService(sender2).notifyUser("user@test.com", "테스트");
    }
}