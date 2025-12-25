package model;

import enums.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {

    private LocalDateTime timestamp;
    private LogLevel level;

    private String threadName;

    private String loggerName;

    private String message;

    public LogMessage(LogLevel level, String loggerName, String message) {
        this.level = level;
        this.loggerName = loggerName;
        this.message = message;
        this.threadName = Thread.currentThread().getName();
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getMessage() {
        return message;
    }
}
