package com.example.spring.springtheory.ch06.task_0701.service;

public class MemberServiceImpl implements MemberService {

    @Override
    public String register(String id) {
        sleep(50);
        return "가입완료: " + id;
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}