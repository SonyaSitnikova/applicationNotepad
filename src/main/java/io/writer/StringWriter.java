package io.writer;

/**
 * Implementation or the stringWriter
 */
public class StringWriter implements IWriter {

    private StringBuilder resultString;

    /**
     * Constructor of the StringWriter
     */
    public StringWriter() {
        resultString = new StringBuilder();
    }

    /**
     *
     * @return resultString
     */
    public final String toString()  {
        return resultString.toString();
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            resultString.append(symbol);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }
    }

    @Override
    public void close() throws WriterException {

    }
}
