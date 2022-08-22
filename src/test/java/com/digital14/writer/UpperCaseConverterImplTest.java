package com.digital14.writer;
import org.junit.Test;

import com.digital14.writer.impl.StringWriterImpl;
import com.digital14.writer.impl.UpperCaseConverterImpl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class UpperCaseConverterImplTest {
	
	@Test
    public void writeOnceAndCheckUpperCaseConverter() throws IOException {
		UpperCaseConverterImpl writer = new UpperCaseConverterImpl(new StringWriterImpl());
        writer.write("Software Design");
        assertEquals("SOFTWARE DESIGN", writer.toString());
    }
	
	  @Test
	    public void writeTwiceAndCheckUpperCaseConverter() throws IOException{
		  UpperCaseConverterImpl writer = new UpperCaseConverterImpl(new StringWriterImpl());
	        writer.write("Software ");
	        writer.write("Design");
	        assertEquals("SOFTWARE DESIGN", writer.toString());
	    }
	    @Test
	    public void callCloseAndCheckUpperCaseConverter() throws IOException{
	    	UpperCaseConverterImpl writer = new UpperCaseConverterImpl(new StringWriterImpl());
	        writer.write("Software");
	        writer.close();
	        writer.write("Design");
	        assertEquals("SOFTWARE", writer.toString());
	    }

}
