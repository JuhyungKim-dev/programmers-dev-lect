package com.example.spring.springtheory.ch01.task_0622;

import java.util.ArrayList;

class Journal {
    private ArrayList<String> entries = new ArrayList<>();
    public void add(String text) {
        entries.add(text);
    }

    public String getText() {
        String result = "";
        for (String entry : entries) {
            result += "- " + entry + "\n";
        }
        return result;
    }
}

class JournalSaver {
    public void print(Journal journal) {
        System.out.print(journal.getText());
    }
}