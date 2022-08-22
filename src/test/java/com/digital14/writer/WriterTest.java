package com.digital14.writer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public abstract class WriterTest {
	
	 private IWriter writer;

	    @Before
	    public void setup() throws IOException {
	        writer = createWriter();
	    }

	    public IWriter getWriter()
	    {
	        return writer;
	    }

	    @Test
	    public void callWriteOnceWhenFileExists() throws IOException
	    {
	        writer.write("Hello");
	        assertEquals("Hello", getContent());
	    }

	    @Test
	    public void callWriteTwice() throws IOException
	    {
	        writer.write("Hello");
	        writer.write("Java");
	        assertEquals("HelloJava", getContent());
	    }

	    @Test
	    public void verifyClose() throws IOException
	    {
	        writer.write("Hello");
	        writer.write("World");
	        writer.close();
	        writer.write("Hello");
	        assertEquals("HelloWorld", getContent());
	    }

	    protected abstract IWriter createWriter() throws IOException;
	    protected abstract String getContent() throws IOException;

}
