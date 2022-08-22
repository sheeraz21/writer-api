package com.digital14.writer;
import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.digital14.writer.impl.FileWriterImpl;

public class FileWriterImplTest extends WriterTest{
	
	String filepath = "sample.txt";

    public String readFile() throws IOException {
        return Files.lines(Paths.get(filepath)).collect(joining(""));
    }

    @Override
    protected IWriter createWriter() throws IOException {
        return new FileWriterImpl(filepath);
    }

    @Override
    protected String getContent() throws IOException {
        return Files.newBufferedReader(Paths.get(filepath)).readLine();
    }

}
