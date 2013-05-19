package com.promindis.jdk8;

public final class BeingLazy implements Delay, Runnable {
  @Override
  public void run() {
    final Holder holder = new Holder();
    holder.getHeavy();
    holder.getHeavy();
  }

  public static void main(final String[] args) {
    new BeingLazy().run();
  }
}
