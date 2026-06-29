package com.example.spring.springtheory.ch05.task_0629;
import java.sql.SQLException;

public class FlakyService {
    private final int failTimes;
    private int callCount = 0;

    FlakyService(int failTimes) {
        this.failTimes = failTimes;
    }

    String fetch() throws java.sql.SQLException {
        callCount++;

        if (callCount <= failTimes) {
            throw new java.sql.SQLException("일시적 오류 (호출 " + callCount + ")");
        }

        return "데이터-OK";
    }
}
