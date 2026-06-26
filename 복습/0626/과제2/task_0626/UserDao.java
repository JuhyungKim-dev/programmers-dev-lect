package com.example.spring.springtheory.ch03.task_0626;

public class UserDao {

    private Database db;
    UserDao(Database db) {
        this.db = db;
    }

    void context(StatementStrategy strategy) {
        db.open();
        strategy.run(db);
        db.close();
    }

    void deleteAllByClass() {
        context(new DeleteAllStrategy());
    }

    void addByClass(User user) {
        context(new AddStrategy(user));
    }

    void deleteAllByAnonymous() {
        StatementStrategy strategy = new StatementStrategy() {
            @Override
            public void run(Database db) {
                db.getUsers().clear();
                System.out.println("  [전략-익명] 전체 삭제");
            }
        };
        context(strategy);
    }

    void addByAnonymous(User user) {
        StatementStrategy strategy = new StatementStrategy() {
            @Override
            public void run(Database db) {
                db.getUsers().add(user);
                System.out.println("  [전략-익명] 추가: " + user.getName());
            }
        };

        context(strategy);
    }

    void deleteAll() {
        context(db -> {
            db.getUsers().clear();
            System.out.println("  [전략-람다] 전체 삭제");
        });
    }

    void add(User user) {
        context(db -> {
            db.getUsers().add(user);
            System.out.println("  [전략-람다] 추가: " + user.getName());
        });
    }
}
