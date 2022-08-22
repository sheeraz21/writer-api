package com.digital14.writer.impl;

import java.io.IOException;

import com.digital14.writer.IWriter;

public class StupidRemoverImpl implements IWriter {

	private IWriter writer;

	public StupidRemoverImpl() {
	};

	@Override
	public void write(String content) throws IOException {
		writer.write(remove(content));

	}

	@Override
	public void close() throws IOException {
		writer.close();

	}

	public StupidRemoverImpl(IWriter iWriter) {
		writer = iWriter;
	}

	public String remove(String string) {
		return string.replaceAll("stupid", "s*****");
	}

	@Override
	public String toString() {
		return writer.toString();
	}

}
