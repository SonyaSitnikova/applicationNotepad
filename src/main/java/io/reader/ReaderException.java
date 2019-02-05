package io.reader;

/**
 * Exception class for reader
 */
public class ReaderException extends Exception {

    /**
     *
     * @param cause Exception
     */
    public ReaderException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message Message Exception
     * @param cause Exception
     */
    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
