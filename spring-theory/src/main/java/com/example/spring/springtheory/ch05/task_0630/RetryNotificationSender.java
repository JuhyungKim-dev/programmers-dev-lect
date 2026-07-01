package com.example.spring.springtheory.ch05.task_0630;

public class RetryNotificationSender implements NotificationSender {
    private final NotificationSender delegate;
    public RetryNotificationSender(NotificationSender delegate) {
        this.delegate = delegate;
    }
    @Override
    public void send(String to, String message) {
        int maxRetry = 3;
        for (int i = 1; i <= maxRetry; i++) {
            try {
                System.out.println("[RETRY] 시도 : " + i);
                delegate.send(to, message);
                return;
            } catch (Exception e) {
                System.out.println("[RETRY] 실패 : " + e.getMessage());
                if (i == maxRetry) {
                    throw e;
                }
            }
        }
    }
}