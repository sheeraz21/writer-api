package com.digital14.writer.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.digital14.writer.IWriter;

public class FileWriterImpl implements IWriter {

	java.io.FileWriter fileWriter;
	private boolean closed;
	Path path;

	public FileWriterImpl(String file) throws IOException {
		fileWriter = new java.io.FileWriter(file);
		path = Paths.get(file);
	}

	@Override
	public void write(String string) throws IOException {
		if (closed == false) {
			fileWriter.write(string);
			fileWriter.flush();
		}
	}

	public void close() {
		closed = true;
	}

}
