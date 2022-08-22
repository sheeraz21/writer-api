package com.digital14.writer;

import org.junit.Test;

import com.digital14.writer.impl.DuplicateRemoverImpl;
import com.digital14.writer.impl.FileWriterImpl;
import com.digital14.writer.impl.LowerCaseConverterImpl;
import com.digital14.writer.impl.StringWriterImpl;
import com.digital14.writer.impl.StupidRemoverImpl;
import com.digital14.writer.impl.UpperCaseConverterImpl;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AllWritersTest {

	@Test
	public void DuplicateRemoverOnStupidRemoverLowerCase() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		LowerCaseConverterImpl lowerCaseConverter = new LowerCaseConverterImpl(stringWriter);
		StupidRemoverImpl stupidRemover = new StupidRemoverImpl(lowerCaseConverter);
		IWriter combinedWriter = new DuplicateRemoverImpl(stupidRemover);
		combinedWriter.write("HELLO STUPID STUPID WORLD");
		assertEquals("hello stupid world", combinedWriter.toString());
	}

	@Test
	public void DuplicateRemoverOnStupidRemoverUpperCase() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		UpperCaseConverterImpl upperCaseConverter = new UpperCaseConverterImpl(stringWriter);
		StupidRemoverImpl stupidRemover = new StupidRemoverImpl(upperCaseConverter);
		IWriter combinedWriter = new DuplicateRemoverImpl(stupidRemover);
		combinedWriter.write("hello stupid stupid world");
		assertEquals("HELLO S***** WORLD", combinedWriter.toString());
	}

	@Test
	public void stupidRemoverOnUpperCase() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		UpperCaseConverterImpl upperCaseConverter = new UpperCaseConverterImpl(stringWriter);
		StupidRemoverImpl combinedWriter = new StupidRemoverImpl(upperCaseConverter);
		combinedWriter.write("HELLO stupid world");
		assertEquals("HELLO S***** WORLD", combinedWriter.toString());
	}

	@Test
	public void stupidRemoverOnLowerWithFileWriter() throws IOException {
		FileWriterImpl fileWriter = new FileWriterImpl("sample.txt");
		LowerCaseConverterImpl lowerCaseConverter = new LowerCaseConverterImpl(fileWriter);
		StupidRemoverImpl stupidRemover = new StupidRemoverImpl(lowerCaseConverter);
		IWriter combinedWriter = new DuplicateRemoverImpl(stupidRemover);
		combinedWriter.write("hello stupid stupid world");
		assertEquals("hello s***** world", new FileWriterImplTest().readFile());
	}

	@Test
	public void stupidRemoverOnUpper() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		UpperCaseConverterImpl upperCaseConverter = new UpperCaseConverterImpl(stringWriter);
		StupidRemoverImpl stupidRemover = new StupidRemoverImpl(upperCaseConverter);
		IWriter combinedWriter = new DuplicateRemoverImpl(stupidRemover);
		combinedWriter.write("hello stupid stupid world");
		assertEquals("HELLO S***** WORLD", combinedWriter.toString());
	}

	@Test
	public void duplicateRemoverOnLowerCase() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		LowerCaseConverterImpl lowerCaseConverter = new LowerCaseConverterImpl(stringWriter);
		DuplicateRemoverImpl combinedWriter = new DuplicateRemoverImpl(lowerCaseConverter);
		combinedWriter.write("HELLO STUPID STUPID WORLD");
		assertEquals("hello stupid world", combinedWriter.toString());
	}

	@Test
	public void duplicateRemoverOnStupidRemover() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		StupidRemoverImpl stupidRemover = new StupidRemoverImpl(stringWriter);
		DuplicateRemoverImpl combinedWriter = new DuplicateRemoverImpl(stupidRemover);
		combinedWriter.write("Hello stupid world world");
		assertEquals("Hello s***** world", combinedWriter.toString());
	}

	@Test
	public void duplicateRemoverOnUpperCase() throws IOException {
		StringWriterImpl stringWriter = new StringWriterImpl();
		UpperCaseConverterImpl upperCaseConverter = new UpperCaseConverterImpl(stringWriter);
		DuplicateRemoverImpl combinedWriter = new DuplicateRemoverImpl(upperCaseConverter);
		combinedWriter.write("hello stupid stupid world");
		assertEquals("HELLO STUPID WORLD", combinedWriter.toString());
	}

}
