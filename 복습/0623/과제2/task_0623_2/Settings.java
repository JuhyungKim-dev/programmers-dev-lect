package com.example.spring.springtheory.ch01.task_0623_2;

class Settings {

    private static Settings instance;
    private String theme = "dark";

    private Settings() {
    }

    static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    String getTheme() {
        return theme;
    }

    void setTheme(String theme) {
        this.theme = theme;
    }
}