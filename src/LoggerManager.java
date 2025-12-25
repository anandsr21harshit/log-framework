import appenders.ConsoleAppender;
import appenders.LogAppender;
import enums.LogLevel;
import formatter.DefaultFormatter;
import formatter.LogFormatter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerManager {

    private static volatile boolean initialized = false;
    private static LoggerConfig config;
    private static final Map<String,Logger> loggerCache = new ConcurrentHashMap<>();

    private LoggerManager(){}

    // if a user wants a diff config they can use this api
    public static void initialize(LoggerConfig loggerConfig){
        if(initialized){
            throw new IllegalStateException("LoggerManager already initialized");
        }

        synchronized (LoggerManager.class){
            config = loggerConfig;
            initialized = true;
        }
    }


    public static Logger getLogger(Class<?> targetClass){
        if(!initialized){
            initialize(defaultConfig());
        }

        String loggerName = targetClass.getName();

        return loggerCache.computeIfAbsent(loggerName,key -> new Logger(key,config));

    }

    private static LoggerConfig defaultConfig(){
        LogFormatter logFormatter = new DefaultFormatter();
        LogAppender appender = new ConsoleAppender(logFormatter);

        return new LoggerConfig(LogLevel.INFO, List.of(appender));
    }
}
