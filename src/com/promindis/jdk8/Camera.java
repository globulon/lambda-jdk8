package com.promindis.jdk8;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;

import static com.promindis.jdk8.Functions.identity;

public final class Camera {
  private final Function<Color, Color> filter;

  private Camera(final Function<Color, Color> filter) {
    this.filter = filter;
  }

  public Color capture(final Color inputColor) {
    return filter.apply(inputColor);
  }

  @SafeVarargs
  public static Camera makeCamera(final Function<Color, Color>... filters) {
    final Function<Color, Color> filter = Arrays.asList(filters).stream()
      .reduce((current, next) -> next.compose(current)).orElse(identity());

    return new Camera(filter);
  }

}