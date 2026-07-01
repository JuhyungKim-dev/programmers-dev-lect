package com.example.spring.springtheory.ch05.task_0630;

public class TimingNotificationSender implements NotificationSender {
    private final NotificationSender delegate;
    public TimingNotificationSender(NotificationSender delegate) {
        this.delegate = delegate;
    }
    @Override
    public void send(String to, String message) {
        long start = System.currentTimeMillis();
        delegate.send(to, message);
        long end = System.currentTimeMillis();
        System.out.println("[TIME] 소요 시간 : " + (end - start) + "ms");
    }
}