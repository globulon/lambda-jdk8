package com.promindis.jdk8;

import java.math.BigInteger;
import static java.math.BigInteger.*;

public class Factorial implements TCO {

  private TailCall<BigInteger> factorialTCO(
    final BigInteger fact, final BigInteger remaining) {
    if (remaining.equals(ONE))
      return done(fact);
    else
      return call(() ->
        factorialTCO(fact.multiply(remaining), dec(remaining)));
  }

  private BigInteger dec(final BigInteger remaining) {
    return remaining.subtract(ONE);
  }

  private BigInteger apply(final String from) {
    return factorialTCO(ONE, new BigInteger(from)).invoke();
  }

  public static void main(final String[] args) {
    System.out.println(new Factorial().apply("5"));
    System.out.println(new Factorial().apply("100"));

  }
}
