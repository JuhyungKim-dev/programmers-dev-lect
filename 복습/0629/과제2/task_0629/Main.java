package com.example.spring.springtheory.ch05.task_0629;

public class Main {

    public static void main(String[] args) {

        FileLogger logger = new FileLogger();
        DataService service = new DataService(logger);

        try {
            System.out.println(service.fetchWithRetry(new FlakyService(2)));
        } catch (RuntimeException e) {
            System.out.println("실패: " + e.getMessage());
        }

        try {
            service.fetchWithRetry(new FlakyService(99));
        } catch (RuntimeException e) {
            System.out.println("실패: " + e.getMessage());
        }

        try {
            service.registerUser("kim");
        } catch (DataService.DuplicateUserIdException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        System.out.println(logger.getLogFilePath());
    }
}