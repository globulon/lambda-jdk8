package com.promindis.jdk8;

import java.io.IOException;

public final class WriteSomething implements Writes {

  public void run() throws IOException {
    use("eam.txt", writer -> writer.writeStuff("sweet"));
    use("eam2.txt", writer -> {
      writer.writeStuff("how");
      writer.writeStuff("sweet");
    });

  }

  public static void main(final String[] args) throws IOException {
    new WriteSomething().run();
  }
}
