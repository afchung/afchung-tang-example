package com.afchung.tang.example.top.parameters;

import com.afchung.tang.example.top.Top;
import org.apache.reef.tang.annotations.Name;
import org.apache.reef.tang.annotations.NamedParameter;

import java.util.Set;

/**
 * Created by anchung on 10/26/2015.
 */
@NamedParameter
public final class TopLayers implements Name<Set<Top>> {
  private TopLayers() {
  }
}
