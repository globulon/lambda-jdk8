package com.promindis.jdk8;

import java.io.FileWriter;
import java.io.IOException;

import static com.promindis.jdk8.Functions.UseInstance;

interface Writes {
  class FileWriterEAM {
    private final FileWriter writer;
    private FileWriterEAM(final String fileName) throws IOException {
      writer = new FileWriter(fileName);
    }
    private void close() throws IOException {
      System.out.println("close called automatically...");
      writer.close();
    }
    public void writeStuff(final String message) throws IOException {
      writer.write(message);
    }
  }

  default void use(final String fileName, final UseInstance<FileWriterEAM,IOException> block) throws IOException {
    final FileWriterEAM fw = new FileWriterEAM(fileName);
    try {
      block.accept(fw);
    } finally {
      fw.close();
    }
  }
}