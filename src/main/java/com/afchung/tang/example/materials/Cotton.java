package com.afchung.tang.example.materials;

import javax.inject.Inject;

/**
 * Created by anchung on 10/27/2015.
 */
public final class Cotton implements Material {
  @Inject
  public Cotton(){
  }

  public String getName() {
    return "Cotton";
  }

  public int getWarmness() {
    return 50;
  }

  @Override
  public String toString() {
    return getName();
  }
}
