package com.example.spring.springtheory.ch01.task_0623_1;

interface ClickListener {
    void onClick();
}

class Button {
    private ClickListener listener;

    void setListener(ClickListener listener) {
        this.listener = listener;
    }

    void press() {
        System.out.println("[시스템] 버튼이 눌렸습니다");
        listener.onClick();
    }
}

class LikeAction implements ClickListener {

    public void onClick() {
        System.out.println("내 코드 실행: 좋아요!");
    }
}
