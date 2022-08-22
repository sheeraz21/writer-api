package com.digital14.writer;
import org.junit.Before;

import com.digital14.writer.impl.StringWriterImpl;

import java.io.IOException;
public class StringWriterImplTest extends WriterTest{
	
	 private StringWriterImpl stringWriter;
	 
	 @Before
	    public void setUp(){
	        stringWriter = new StringWriterImpl();
	    }

	    @Override
	    protected IWriter createWriter() throws IOException {
	        return new StringWriterImpl();
	    }

	    @Override
	    protected String getContent() {
	        return getWriter().toString();
	    }

}
