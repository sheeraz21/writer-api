package com.digital14.writer.impl;

import com.digital14.writer.IWriter;

public class StringWriterImpl implements IWriter {

	private StringBuilder content = new StringBuilder();
	private boolean open = true;

	public void write(String string) {
		if (open) {
			content = content.append(string);
		}
	}

	public String toString() {
		return content.toString();
	}

	public void close() {
		open = false;
	}

}