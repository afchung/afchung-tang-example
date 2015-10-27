package com.afchung.tang.example.materials;

import javax.inject.Inject;

/**
 * Created by anchung on 10/27/2015.
 */
public final class Shiny implements Material {
  @Inject
  public Shiny(){
  }

  public String getName() {
    return "Shiny";
  }

  public int getWarmness() {
    return 1;
  }

  @Override
  public String toString() {
    return getName();
  }
}
