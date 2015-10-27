package com.afchung.tang.example.pants;

import javax.inject.Inject;

/**
 * Created by anchung on 10/27/2015.
 */
public final class Jeans implements Pants {
  @Inject
  private Jeans(){
  }

  public String getName() {
    return "Jeans";
  }

  public String getColor() {
    return "Blue";
  }
}
