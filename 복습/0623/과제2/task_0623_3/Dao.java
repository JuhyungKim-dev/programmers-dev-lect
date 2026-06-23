package com.example.spring.springtheory.ch01.task_0623_3;

interface ConnectionMaker {
    String makeConnection();
}

class SimpleConnectionMaker implements ConnectionMaker {
    private static final SimpleConnectionMaker instance = new SimpleConnectionMaker();
    private SimpleConnectionMaker() {
    }

    static SimpleConnectionMaker getInstance() {
        return instance;
    }

    public String makeConnection() {
        return "DB연결";
    }
}

class UserDao {
    private static final UserDao instance = new UserDao();
    private ConnectionMaker connectionMaker = SimpleConnectionMaker.getInstance();

    private UserDao() {
    }

    static UserDao getInstance() {
        return instance;
    }

    String findUser(String userId) {
        return userId + " 조회 [" + connectionMaker.makeConnection() + "]";
    }
}