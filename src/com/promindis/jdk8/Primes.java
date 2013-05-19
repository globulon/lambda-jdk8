package com.promindis.jdk8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Primes {

  private static boolean isPrime(final int number) {
     return number > 1 &&
       IntStream
         .range(2, (int) Math.sqrt(number) + 1)
         .noneMatch(divisor -> number % divisor == 0);
  }

  private static int primeAfter(final int number) {
    if (isPrime(number + 1)) return number + 1;
    else return primeAfter(number + 1);
  }

  private static List<Integer> primes(final int from, final int take){
    return Stream
      .iterate(primeAfter(from), Primes::primeAfter)
      .limit(take)
      .collect(Collectors.toList());
  }

  public static void main(final String[] args) {
    System.out.println("10 primes from 1: " + primes(1, 10));
    System.out.println("5 primes from 100: " + primes(100, 5));
  }
}
