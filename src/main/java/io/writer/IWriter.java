package io.writer;

/**
 * FileWriter interface
 */
public interface IWriter extends AutoCloseable{
    /**
     *
     * @param symbol for write
     * @throws WriterException if there was a write error
     */
    void write(char symbol) throws WriterException;

    void close()throws WriterException;
}
