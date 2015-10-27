package com.afchung.tang.example.top.jacket;

import com.afchung.tang.example.top.jacket.parameters.JacketColor;
import com.afchung.tang.example.top.jacket.parameters.JacketLength;
import com.afchung.tang.example.top.jacket.parameters.JacketThickness;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;

/**
 * Created by anchung on 10/26/2015.
 */
public final class DownJacket implements Jacket {
  private int thickness;
  private int length;
  private String color;

  @Inject
  private DownJacket(@Parameter(JacketThickness.class) final int thickness,
                     @Parameter(JacketColor.class) final String color,
                     @Parameter(JacketLength.class) final int length) {
    this.thickness = thickness;
    this.color = color;
    this.length = length;
  }

  public int getThickness() {
    return this.thickness;
  }

  public int getTopLength() {
    return this.length;
  }

  public String getColor() {
    return this.color;
  }

  public String getName() {
    return "Down";
  }
}
