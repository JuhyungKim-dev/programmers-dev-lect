package com.example.spring.springtheory.ch01.task_0623_1;

class CoffeeContainer {

    CoffeeMaker getCoffeeMaker() {
        Bean bean = new ColombiaBean();
        return new CoffeeMaker(bean);
    }
}