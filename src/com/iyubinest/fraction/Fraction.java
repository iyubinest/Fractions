package com.iyubinest.fraction;

import java.util.Objects;

final class Fraction {

  public static Fraction of(int numerator) {
    return new Fraction(numerator);
  }

  public static Fraction of(int numerator, int denominator) {
    return new Fraction(numerator, denominator);
  }

  private static final int DEFAULT_DENOMINATOR = 1;

  private final int numerator;

  private final int denominator;

  private Fraction(Builder builder) {
    this(builder.numerator, builder.denominator);
  }

  private Fraction(int numerator) {
    this(numerator, DEFAULT_DENOMINATOR);
  }

  private Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int numerator() {
    return numerator;
  }

  public int denominator() {
    return denominator;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Fraction fraction = (Fraction) o;
    return numerator == fraction.numerator &&
        denominator == fraction.denominator;
  }

  @Override public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  @Override
  public String toString() {
    return String.format("%s/%s", numerator, denominator);
  }

  public static final class Builder {

    private int numerator;
    private int denominator = DEFAULT_DENOMINATOR;

    public Builder withNumerator(int numerator) {
      this.numerator = numerator;
      return this;
    }

    public Builder withDenominator(int denominator) {
      this.denominator = denominator;
      return this;
    }

    public Fraction build() {
      Preconditions.check(denominator != 0, "Invalid denominator");
      return new Fraction(this);
    }
  }
}
