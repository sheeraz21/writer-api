package com.digital14.writer;

import java.io.IOException;

public interface IWriter {

	public void write(String content) throws IOException;

	public void close() throws IOException;

}
