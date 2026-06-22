package com.example.spring.springtheory.ch01.task_0622;

class Bird {
    public void eat() {
        System.out.println("냠냠 먹습니다");
    }
}

class FlyingBird extends Bird {
    public void fly() {
        System.out.println("훨훨 납니다");
    }
}

class Sparrow extends FlyingBird {
}

class Penguin extends Bird {
    public void swim() {
        System.out.println("첨벙 헤엄칩니다");
    }
}