package com.example.spring.springtheory.ch01.task_0624_2;
import java.util.List;

class Order {

    private int id;
    private List<String> items;

    public Order(int id, List<String> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public List<String> getItems() {
        return items;
    }
}