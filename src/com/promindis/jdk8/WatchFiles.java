package com.promindis.jdk8;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class WatchFiles {

  private WatchFiles() {
    super();
  }

  private Consumer<? super WatchEvent> traceEvent =
    evt -> System.out.println(evt.context());

  private void run() throws IOException, InterruptedException {
    final WatchService srv = makeWatcher(Paths.get("."));

    System.out.println("Report any file changed within next 1 minutes...");

    final WatchKey k = srv.poll(1, TimeUnit.MINUTES);

    if (k != null) {
      k.pollEvents().stream().forEach(traceEvent);
    }
  }

  private WatchService makeWatcher(final Path p) throws IOException {
    final WatchService srv = p.getFileSystem().newWatchService();
    p.register(srv, StandardWatchEventKinds.ENTRY_MODIFY);
    return srv;
  }

  public static void main(final String[] args) throws IOException, InterruptedException {
    new WatchFiles().run();
  }
}
