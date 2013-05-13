package com.promindis.jdk8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.CloseableStream;

import static java.nio.file.Files.newDirectoryStream;
import com.promindis.jdk8.Messages.*;

public final class ListFiles implements Messages {

  private BiPredicate<Path, BasicFileAttributes> isHidden =
    (p, attributes) -> ((DosFileAttributes)attributes).isHidden();

  private void run() throws IOException {
    this.<Path>trace("list files:").accept(
      newDirectoryStream(Paths.get(".")).entries().filter(Files::isDirectory));

    this.<Path>trace("list java files:").accept(
      newDirectoryStream(
        Paths.get("src/com/promindis/jdk8"), path -> path.toString().endsWith(".java"))
        .entries());

    final File[] fs = new File(".").listFiles(File::isHidden);
    Arrays.asList(fs).stream().forEach(System.out::println);
    try(final CloseableStream<Path> p = Files.find(Paths.get("."), 1, isHidden)) {
      p.forEach(System.out::println);
    }
  }

  public static void main(final String[] args) throws IOException {
    new ListFiles().run();
  }
}
