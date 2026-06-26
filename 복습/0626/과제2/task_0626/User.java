package com.example.spring.springtheory.ch03.task_0626;

public class User {

    private String id;
    private String name;

    User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }
}