package com.promindis.jdk8;

public final class Transports implements Flies, Transport, Runnable {

  private Transports() {
    super();
  }

  public SeaPlane goUp(final int delta, final SeaPlane sp) {
    return new SeaPlane(sp.altitude + delta);
  }

  private SeaPlane seaPlane() {
    return new SeaPlane(0);
  }

  @Override
  public void run() {
    SeaPlane seaPlane = seaPlane();
    seaPlane.takeOff();
    seaPlane.turn();
    seaPlane.cruise();
    seaPlane.land();

    seaPlane().cruise();
    goUp(5, seaPlane()).cruise();
  }

  public final class SeaPlane extends Vehicle implements FastFly, Sail {
    private final int altitude;

    public SeaPlane(final int altitude) {
      this.altitude = altitude;
    }

    public void cruise() {
      System.out.print("SeaPlane::cruise currently cruise like: ");
      if(altitude > 0)
        FastFly.super.cruise();
      else
        Sail.super.cruise();
    }
  }

  public static void main(final String[] args) {
    new Transports().run();
  }
}
