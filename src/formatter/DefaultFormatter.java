package formatter;

import model.LogMessage;

public class DefaultFormatter implements LogFormatter{
    @Override
    public String format(LogMessage message) {
        return String.format("%s [%s] [%s] [%s] %s",
                message.getTimestamp(),
                message.getThreadName(),
                message.getLevel(),
                message.getLoggerName(),
                message.getMessage());
    }
}
