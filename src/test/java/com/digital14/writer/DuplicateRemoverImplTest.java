package com.digital14.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.digital14.writer.impl.DuplicateRemoverImpl;
import com.digital14.writer.impl.StringWriterImpl;

public class DuplicateRemoverImplTest {
	
	  static DuplicateRemoverImpl duplicateRemover;

	    @BeforeAll
	    public void setup()
	    {
	        duplicateRemover = new DuplicateRemoverImpl(new StringWriterImpl());
	    }

	    @Test
	    public void testDuplicateRemover() throws IOException {
	        String string = "This is duplicate duplicate remover";
	        String stringAfterConversion = "This is duplicate remover";
	        String convertedString = duplicateRemover.remove(string);
	        assertTrue(convertedString.equals(stringAfterConversion));
	    }

	    @Test
	    public void callDuplicateRemoverClose() throws IOException{
	    	DuplicateRemoverImpl duplicateRemover = new DuplicateRemoverImpl(new StringWriterImpl());
	        duplicateRemover.write("This is duplicate remover");
	        duplicateRemover.close();
	        duplicateRemover.write("remover");
	        assertEquals("This is duplicate remover", duplicateRemover.toString());
	    }

}
