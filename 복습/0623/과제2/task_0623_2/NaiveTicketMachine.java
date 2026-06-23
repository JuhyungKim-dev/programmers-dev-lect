package com.example.spring.springtheory.ch01.task_0623_2;

class NaiveTicketMachine {

    private int lastNumber = 0;

    int issue() {
        lastNumber++;
        return lastNumber;
    }
}