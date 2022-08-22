package com.digital14.writer.impl;

import java.io.IOException;

import com.digital14.writer.IWriter;

public class LowerCaseConverterImpl implements IWriter {

	private IWriter writer;

	public LowerCaseConverterImpl(IWriter iWriter) {
		writer = iWriter;
	}

	public String convert(String string) {
		return string.toLowerCase();
	}

	@Override
	public void write(String content) throws IOException {
		writer.write(convert(content));

	}

	@Override
	public void close() throws IOException {
		writer.close();

	}

	@Override
	public String toString() {
		return writer.toString();
	}

}
