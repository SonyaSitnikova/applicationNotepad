package io.reader;

/**
 * Reader interface
 */
public interface IReader extends AutoCloseable{
    /**
     *
     * @return true, if read next symbol
     * @throws ReaderException if there was a read error
     */
    boolean hasNextChar() throws ReaderException;

    /**
     *
     * @return getChar
     * @throws ReaderException if there was a read error
     */
    char readChar() throws ReaderException;

    void close() throws ReaderException;
}
