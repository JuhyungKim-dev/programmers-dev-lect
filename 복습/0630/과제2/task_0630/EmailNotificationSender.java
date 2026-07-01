package com.example.spring.springtheory.ch05.task_0630;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(String to, String message) {
        System.out.printf("[EMAIL] to=%s : %s%n", to, message);
    }
}