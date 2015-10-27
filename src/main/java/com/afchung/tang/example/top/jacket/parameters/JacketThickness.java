package com.afchung.tang.example.top.jacket.parameters;

import org.apache.reef.tang.annotations.Name;
import org.apache.reef.tang.annotations.NamedParameter;

/**
 * Created by anchung on 10/26/2015.
 */
@NamedParameter(default_value = "1")
public final class JacketThickness implements Name<Integer> {
  private JacketThickness() {
  }
}
