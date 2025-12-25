import appenders.LogAppender;
import enums.LogLevel;
import model.LogMessage;

public class Logger {

    private final String name;
    private final LoggerConfig loggerConfig;

    public Logger(String name, LoggerConfig loggerConfig) {
        this.name = name;
        this.loggerConfig = loggerConfig;
    }

    private void log(LogLevel level, String message){
        if(!loggerConfig.shouldLog(level)) return;

        LogMessage logMessage = new LogMessage(level,name,message);

        for(LogAppender appender : loggerConfig.getAppenders()){
            appender.append(logMessage);
        }
    }

    public void debug(String msg){
        log(LogLevel.DEBUG,msg);
    }

    public void info(String msg){
        log(LogLevel.INFO,msg);
    }

    public void warn(String msg){
        log(LogLevel.WARN,msg);
    }

    public void error(String msg){
        log(LogLevel.ERROR,msg);
    }

    public void fatal(String msg){
        log(LogLevel.FATAL,msg);
    }
}
