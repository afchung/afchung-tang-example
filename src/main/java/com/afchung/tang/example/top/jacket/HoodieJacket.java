package com.afchung.tang.example.top.jacket;

import com.afchung.tang.example.top.jacket.parameters.JacketColor;
import com.afchung.tang.example.top.jacket.parameters.JacketLength;
import com.afchung.tang.example.top.jacket.parameters.JacketThickness;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;

/**
 * Created by anchung on 10/26/2015.
 */
public final class HoodieJacket implements Jacket {
  private int thickness;
  private int length;
  private String color;

  @Inject
  private HoodieJacket(@Parameter(JacketThickness.class) int thickness,
                       @Parameter(JacketColor.class) String color,
                       @Parameter(JacketLength.class) int length) {
    this.thickness = thickness;
    this.color = color;
    this.length = length;
  }

  public int getThickness() {
    return this.thickness;
  }

  public String getColor() {
    return this.color;
  }

  public int getTopLength() {
    return this.length;
  }

  public String getName() {
    return "Hoodie";
  }
}
