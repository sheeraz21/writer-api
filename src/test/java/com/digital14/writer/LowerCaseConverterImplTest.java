package com.digital14.writer;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.digital14.writer.impl.LowerCaseConverterImpl;
import com.digital14.writer.impl.StringWriterImpl;

public class LowerCaseConverterImplTest {
	
	 @Test
	    public void writeOnceAndCheckLowerCaseConverter() throws IOException {
	        LowerCaseConverterImpl writer = new LowerCaseConverterImpl(new StringWriterImpl());
	        writer.write("Software Design");
	        assertEquals("software design", writer.toString());
	    }

	 
	   @Test
	    public void writeTwiceAndCheckLowerCaseConverter() throws IOException{
		   LowerCaseConverterImpl writer = new LowerCaseConverterImpl(new StringWriterImpl());
	        writer.write("Software");
	        writer.write("Design");
	        assertEquals("softwaredesign", writer.toString());
	    }
	   
	   @Test
	    public void callCloseAndCheckLowerCaseConverter() throws IOException{
		   LowerCaseConverterImpl writer = new LowerCaseConverterImpl(new StringWriterImpl());
	        writer.write("Software");
	        writer.close();
	        writer.write("Design");
	        assertEquals("software", writer.toString());
	    }
	   @Test
	    public void callStupidRemoverCloseAndCheckLowerCaseConverter() throws IOException{
		   LowerCaseConverterImpl writer = new LowerCaseConverterImpl(new StringWriterImpl());
	        writer.write("Software");
	        writer.close();
	        writer.write("Design");
	        assertEquals("software", writer.toString());
	    }
}
