package com.promindis.jdk8;

import java.util.function.Supplier;

public interface Delay {

  public class Heavy {
    public Heavy() { System.out.println("Heavy created"); }
    public String toString() { return "quite heavy"; }
  }

  final class Holder {
    Supplier<Heavy> heavy = this::createAndCacheHeavy;

    public Holder() {
      super();
      System.out.println("Holder created");
    }

    public Heavy getHeavy() {
      return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
      class HeavyFactory implements Supplier<Heavy> {
        private final Heavy heavyInstance = new Heavy();
        public Heavy get() { return heavyInstance; }
      }
      if(!HeavyFactory.class.isInstance(heavy)) {
        heavy = new HeavyFactory();
      }
      return heavy.get();
    }
  }
}
