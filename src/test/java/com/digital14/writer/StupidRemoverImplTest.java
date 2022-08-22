package com.digital14.writer;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.digital14.writer.impl.StringWriterImpl;
import com.digital14.writer.impl.StupidRemoverImpl;

public class StupidRemoverImplTest {
	
	 static StupidRemoverImpl stupidRemover;
	 
	 @Before
	    public void setup()
	    {
	        stupidRemover = new StupidRemoverImpl();
	    }
	 
	  @Test
	    public void testStupidRemover() throws IOException {
	        String string = "This is stupid remover";
	        String stringAfterConversion = "This is s***** remover";
	        String convertedString = stupidRemover.remove(string);
	        assertTrue(convertedString.equals(stringAfterConversion));
	    }
	  
	    @Test
	    public void callStupidRemoverClose() throws IOException{
	    	StupidRemoverImpl stupidRemover = new StupidRemoverImpl(new StringWriterImpl());
	        stupidRemover.write("stupid");
	        stupidRemover.close();
	        stupidRemover.write("Revomer");
	        assertEquals("s*****", stupidRemover.toString());
	    }

}
