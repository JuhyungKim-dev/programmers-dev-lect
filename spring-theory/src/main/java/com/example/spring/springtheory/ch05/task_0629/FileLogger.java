package com.example.spring.springtheory.ch05.task_0629;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileLogger {

    private final File logDir;
    private final File logFile;

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    FileLogger() {
        String home = System.getProperty("user.home");
        logDir = new File(home, "Desktop/app-logs");
        logFile = new File(logDir, "app.log");
    }

    void log(String level, String message) {
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        String line = LocalDateTime.now().format(FMT)
                + " [" + level + "] " + message
                + System.lineSeparator();

        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write(line);
        } catch (IOException e) {
            System.out.println("로그 실패: " + e.getMessage());
        }
    }

    String getLogFilePath() {
        return logFile.getAbsolutePath();
    }
}