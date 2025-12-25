package appenders;

import formatter.LogFormatter;
import model.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{

    private final LogFormatter formatter;
    private final BufferedWriter bufferedWriter;

    public FileAppender(LogFormatter formatter, String filepath) throws IOException {
        this.formatter = formatter;
        this.bufferedWriter = new BufferedWriter(new FileWriter(filepath,true));
    }

    @Override
    public synchronized void append(LogMessage message) {
        try {
            bufferedWriter.append(formatter.format(message));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
