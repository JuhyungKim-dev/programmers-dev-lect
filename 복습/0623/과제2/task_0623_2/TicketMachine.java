package com.example.spring.springtheory.ch01.task_0623_2;

class TicketMachine {

    private static final TicketMachine instance = new TicketMachine();
    private int lastNumber = 0;

    private TicketMachine() {
    }

    static TicketMachine getInstance() {
        return instance;
    }

    int issue() {
        lastNumber++;
        return lastNumber;
    }
}