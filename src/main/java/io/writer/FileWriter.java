package io.writer;

import java.io.*;

/**
 * Implementation of the writer
 */
public class FileWriter implements IWriter {

    private BufferedWriter bufferedWriter;

    /**
     *
     * @param path where output
     * @throws WriterException if there was a write error
     */
    public FileWriter(final String path) throws WriterException {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(path));
            Writer fileWriter = new OutputStreamWriter(outputStream, "utf-8");
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new WriterException("Opening file error", e);
        }
    }

    @Override
    public void close() throws WriterException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new WriterException("Closing error", e);
        }
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
    }
}
