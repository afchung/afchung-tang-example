package com.afchung.tang.example;

import com.afchung.tang.example.pants.Pants;
import com.afchung.tang.example.sock.Socks;
import com.afchung.tang.example.top.Top;
import com.afchung.tang.example.top.parameters.TopLayers;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by anchung on 10/26/2015.
 */
public final class MyOutfit {
  private final String SYS_SEPARATOR = System.getProperty("line.separator");
  private final Set<Top> topLayers;
  private final Pants pants;
  private final Socks socks;
  private final Wearer wearer;

  @Inject
  private MyOutfit(@Parameter(TopLayers.class) final Set<Top> topLayers,
                   final Pants pants,
                   final Socks socks,
                   final Wearer wearer) {
    this.topLayers = topLayers;
    this.socks = socks;
    this.wearer = wearer;
    this.pants = pants;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Wearer name is: " + wearer.getName());

    int i = 1;
    for (final Top top : topLayers) {
      sb.append(SYS_SEPARATOR);
      sb.append("#" + i + " top layer is: " + top.getName() + SYS_SEPARATOR);
      sb.append("#" + i + " top layer color is: " + top.getColor() + SYS_SEPARATOR);
      sb.append("#" + i + " top layer length is: " + top.getTopLength());
      i++;
    }

    sb.append(SYS_SEPARATOR);
    sb.append("Socks are: " + socks.getName() + SYS_SEPARATOR);
    sb.append("Socks are made of: " + socks.getMaterial() + SYS_SEPARATOR);
    sb.append("Sock warmness is: " + socks.getMaterial().getWarmness() + SYS_SEPARATOR);

    sb.append("Pants are: " + pants.getName() + SYS_SEPARATOR);
    sb.append("Pants color is: " + pants.getColor());

    return sb.toString();
  }
}
