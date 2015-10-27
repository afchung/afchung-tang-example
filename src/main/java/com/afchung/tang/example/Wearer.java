package com.afchung.tang.example;

import javax.inject.Inject;

/**
 * Created by anchung on 10/26/2015.
 */
public final class Wearer {
  @Inject
  private Wearer() {
  }

  public String getName() {
    return "DefaultWearer";
  }
}
