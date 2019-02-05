package io;

import io.reader.IReader;
import io.reader.ReaderException;
import io.reader.StringReader;
import io.writer.IWriter;
import io.writer.StringWriter;
import io.writer.WriterException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReaderWriterTest {

    @Test
    public void test_io1() throws ReaderException, WriterException {
        IReader in = new StringReader("Hello world");
        IWriter out = new StringWriter();
        while (in.hasNextChar()) {
            char ch = in.readChar();
            out.write(ch);
        }
        assertEquals("Hello world", out.toString());
    }

    @Test
    public void test_io2() throws ReaderException, WriterException {
        IReader in = new StringReader("Кириллица");
        IWriter out = new StringWriter();
        while (in.hasNextChar()) {
            char ch = in.readChar();
            out.write(ch);
        }
        assertEquals("Кириллица", out.toString());
    }

    @Test
    public void test_io3() throws ReaderException, WriterException {
        IReader in = new StringReader("!@#$%^&*()_+-=");
        IWriter out = new StringWriter();
        while (in.hasNextChar()) {
            char ch = in.readChar();
            out.write(ch);
        }
        assertEquals("!@#$%^&*()_+-=", out.toString());
    }

    @Test
    public void test_io4() throws ReaderException, WriterException {
        IReader in = new StringReader("[]{};:,./<>?");
        IWriter out = new StringWriter();
        while (in.hasNextChar()) {
            char ch = in.readChar();
            out.write(ch);
        }
        assertEquals("[]{};:,./<>?", out.toString());
    }

}

