package com.example.spring.springtheory.ch03.task_0626;

public class DeleteAllStrategy implements StatementStrategy {

    @Override
    public void run(Database db) {

        db.getUsers().clear();

        System.out.println("  [전략-별도클래스] 전체 삭제");
    }
}
