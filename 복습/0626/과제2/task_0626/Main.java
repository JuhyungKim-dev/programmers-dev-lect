package com.example.spring.springtheory.ch03.task_0626;

public class Main {

    public static void main(String[] args) {

        Database db = new Database();
        UserDao dao = new UserDao(db);
        System.out.println("== (별도 클래스) deleteAll ==");
        dao.deleteAllByClass();
        System.out.println();
        System.out.println("== (익명 클래스) add(김) ==");
        dao.addByAnonymous(new User("u1", "김"));
        System.out.println();
        System.out.println("== (람다) add(이) ==");
        dao.add(new User("u2", "이"));
        System.out.println();
        System.out.println("현재 사용자 수: " + db.getUsers().size());

        for (User user : db.getUsers()) {
            System.out.println("사용자: " + user.getName());
        }
    }
}