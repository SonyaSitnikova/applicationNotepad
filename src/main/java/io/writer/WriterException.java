package io.writer;

/**
 * Exception class for writer
 */
public class WriterException extends Exception {

    /**
     *
     * @param cause Exception
     */

    public WriterException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message Message Exception
     * @param cause Exception
     */
    public WriterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}