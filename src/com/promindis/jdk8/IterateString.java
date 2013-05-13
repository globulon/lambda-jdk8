package com.promindis.jdk8;

public final class IterateString {
  private static void printChar(int aChar) {
    System.out.println((char)(aChar));
  }

  public static void main(final String[] args) {
    "W00t".chars().forEach(System.out::println);
    "W00t".chars().forEach(IterateString::printChar);
    "W00t".chars().filter(Character::isDigit).forEach(IterateString::printChar);


  }
}
