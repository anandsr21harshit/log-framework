import appenders.ConsoleAppender;
import appenders.LogAppender;
import enums.LogLevel;
import formatter.DefaultFormatter;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LogAppender appender = new ConsoleAppender(new DefaultFormatter());
        LoggerConfig config = new LoggerConfig(LogLevel.DEBUG, List.of(appender));
        LoggerManager.initialize(config);
        Logger logger = LoggerManager.getLogger(Main.class);

        logger.debug("My age is 20");
        logger.info("Hey Harshit");

        new PaymentService().processPayment();
    }
}