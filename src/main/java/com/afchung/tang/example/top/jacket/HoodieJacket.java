package com.afchung.tang.example.top.jacket;

import com.afchung.tang.example.top.jacket.parameters.Color;
import com.afchung.tang.example.top.jacket.parameters.Length;
import com.afchung.tang.example.top.jacket.parameters.Thickness;
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
    private HoodieJacket(@Parameter(Thickness.class) int thickness,
                         @Parameter(Color.class) String color,
                         @Parameter(Length.class) int length) {
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

    public int getLength() {
        return this.length;
    }

    public String getName() {
        return "Hoodie";
    }
}
