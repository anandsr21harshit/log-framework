package appenders;

import formatter.LogFormatter;
import model.LogMessage;

public class ConsoleAppender implements LogAppender{

    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public synchronized void append(LogMessage message) {
        System.out.println(formatter.format(message));
    }
}
