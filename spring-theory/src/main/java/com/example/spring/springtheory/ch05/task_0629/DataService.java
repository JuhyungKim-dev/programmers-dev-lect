package com.example.spring.springtheory.ch05.task_0629;
import java.sql.SQLException;
import java.util.List;

public class DataService {

        private final FileLogger logger;

        DataService(FileLogger logger) {
            this.logger = logger;
        }

        String fetchWithRetry(FlakyService flaky) {
            int max = 3;

            for (int i = 1; i <= max; i++) {
                try {
                    String result = flaky.fetch();
                    logger.log("INFO", i + "번째 성공: " + result);
                    return result;
                } catch (SQLException e) {
                    logger.log("WARN", i + "번째 실패: " + e.getMessage());
                }
            }

            logger.log("ERROR", "재시도 실패");
            throw new RuntimeException("재시도 3회 실패");
        }

        void avoidByThrows(FlakyService f) throws SQLException {
            f.fetch();
        }

        void avoidByRethrow(FlakyService f) throws SQLException {
            try {
                f.fetch();
            } catch (SQLException e) {
                logger.log("WARN", "회피: " + e.getMessage());
                throw e;
            }
        }

        void registerUser(String id) {
            try {
                insertUser(id);
            } catch (SQLException e) {
                if ("23000".equals(e.getSQLState())) {
                    logger.log("ERROR", "중복 아이디: " + id);
                    throw new DuplicateUserIdException(id, e);
                }
                logger.log("ERROR", "DB 오류");
                throw new RuntimeException(e);
            }
        }

        void insertUser(String id) throws SQLException {
            throw new SQLException("duplicate", "23000");
        }

        static class DuplicateUserIdException extends RuntimeException {
            DuplicateUserIdException(String id, Throwable cause) {
                super("이미 존재하는 아이디: " + id, cause);
            }
        }
}
