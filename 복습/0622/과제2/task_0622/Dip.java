package com.example.spring.springtheory.ch01.task_0622;

interface MessageSender {
    void send(String msg);
}

class EmailSender implements MessageSender {

    @Override
    public void send(String msg) {
        System.out.println("[이메일] " + msg);
    }
}

class SmsSender implements MessageSender {

    @Override
    public void send(String msg) {
        System.out.println("[SMS] " + msg);
    }
}

class NotificationService {

    private MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String msg) {
        sender.send(msg);
    }
}