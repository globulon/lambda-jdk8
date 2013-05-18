package com.promindis.jdk8;

public interface Transport {

  public interface Sail {
    default void cruise() {
      System.out.println("Sail::cruise");
    }

    default void turn() {
      System.out.println("Sail::turn");
    }
  }

  public class Vehicle {
    public void turn() {
      System.out.println("Vehicle::turn");
    }
  }

}
