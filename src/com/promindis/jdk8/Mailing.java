package com.promindis.jdk8;

import java.util.function.Consumer;

public interface Mailing {
  public class FluentMailer {
    private FluentMailer() {}
    public FluentMailer from(final String address) { /*... */; return this; }
    public FluentMailer to(final String address) { /*... */; return this; }
    public FluentMailer subject(final String line) { /*... */; return this; }
    public FluentMailer body(final String message) { /*... */; return this; }
  }

  default void send(final Consumer<FluentMailer> block) {
    block.accept(new FluentMailer());
    System.out.println("sending...");
  }
}
