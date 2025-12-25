import appenders.LogAppender;
import enums.LogLevel;

import java.util.List;

public class LoggerConfig {

    private final LogLevel minLogLevel;
    private final List<LogAppender> appenders;

    public LoggerConfig(LogLevel minLogLevel, List<LogAppender> appenders) {
        this.minLogLevel = minLogLevel;
        this.appenders = appenders;
    }

    public boolean shouldLog(LogLevel level){
        return level.getPriority() >= minLogLevel.getPriority();
    }

    public LogLevel getMinLogLevel() {
        return minLogLevel;
    }

    public List<LogAppender> getAppenders() {
        return appenders;
    }
}
