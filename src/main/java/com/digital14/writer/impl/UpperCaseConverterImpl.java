package com.digital14.writer.impl;

import java.io.IOException;

import com.digital14.writer.IWriter;

public class UpperCaseConverterImpl implements IWriter {

	private IWriter writer;

	@Override
	public void write(String content) throws IOException {
		writer.write(convert(content));

	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

	public String convert(String string) {
		return string.toUpperCase();
	}

	public UpperCaseConverterImpl(IWriter iWriter) {
		writer = iWriter;
	}

	@Override
	public String toString() {
		return writer.toString();
	}

}
