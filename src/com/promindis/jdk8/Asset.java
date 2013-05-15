package com.promindis.jdk8;

import java.math.BigDecimal;

public final class Asset {
  enum AssetType { BOND, STOCK  }

  private final AssetType type;
  private final BigDecimal value;

  public Asset(final AssetType type, final BigDecimal value) {
    this.type = type;
    this.value = value;
  }

  public AssetType type() {
    return type;
  }

  public BigDecimal value() {
    return value;
  }

}

