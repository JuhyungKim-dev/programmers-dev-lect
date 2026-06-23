package com.example.spring.springtheory.ch01.task_0623_1;

interface Bean {
    String name();
}

class ColombiaBean implements Bean {
    public String name() {
        return "콜롬비아 원두";
    }
}

class EthiopiaBean implements Bean {
    public String name() {
        return "에티오피아 원두";
    }
}