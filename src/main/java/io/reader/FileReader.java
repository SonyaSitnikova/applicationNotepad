package io.reader;

import java.io.*;

/**
 * Implementation or the reader
 */
public class FileReader implements IReader {
    private BufferedReader bufferedReader;
    private int currentchar;
    private int nextChar;

    /**
     * Constructor FileReader.
     * @param path The path to the file
     * @throws ReaderException error opening file and unsupported character set
     */
    public FileReader(final String path) throws ReaderException {

        try {
            InputStream fileStream = new FileInputStream(new File(path));
            Reader fileReader = new InputStreamReader(fileStream, "utf-8");
            bufferedReader = new BufferedReader(fileReader);
            nextChar = bufferedReader.read();
        } catch (FileNotFoundException e) {
            throw new ReaderException("Opening file error", e);
        } catch (UnsupportedEncodingException e) {
            throw new ReaderException("Unsupported encoding", e);
        } catch (IOException e) {
            throw new ReaderException("file is not chars", e);
        }

    }

    public FileReader(final File path) throws ReaderException {

        try {
            InputStream fileStream = new FileInputStream(path);
            Reader fileReader = new InputStreamReader(fileStream, "utf-8");
            bufferedReader = new BufferedReader(fileReader);
            nextChar = bufferedReader.read();
        } catch (FileNotFoundException e) {
            throw new ReaderException("Opening file error", e);
        } catch (UnsupportedEncodingException e) {
            throw new ReaderException("Unsupported encoding", e);
        } catch (IOException e) {
            throw new ReaderException("file is not chars", e);
        }

    }

    @Override
    public void close() throws ReaderException {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new ReaderException("Closing stream error", e);
        }
    }

    @Override
    public boolean hasNextChar() throws ReaderException {
        return nextChar > -1;
    }

    @Override
    public char readChar() throws ReaderException {
        try {
        currentchar = nextChar;
        nextChar = bufferedReader.read();
        return (char) currentchar;
        } catch (IOException e) {
            throw new ReaderException("Attempting to read outside of the input stream", e);
        }
    }
}
