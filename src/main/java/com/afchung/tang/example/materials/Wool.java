package com.afchung.tang.example.materials;

import javax.inject.Inject;

/**
 * Created by anchung on 10/27/2015.
 */
public final class Wool implements Material {
  @Inject
  public Wool(){
  }

  public String getName() {
    return "Wool";
  }

  public int getWarmness() {
    return 100;
  }

  @Override
  public String toString() {
    return getName();
  }
}
