package com.afchung.tang.example.top.shirt;

import com.afchung.tang.example.top.shirt.parameters.Color;
import com.afchung.tang.example.top.shirt.parameters.Length;
import com.afchung.tang.example.top.shirt.parameters.SleeveLength;
import org.apache.reef.tang.annotations.Parameter;

import javax.inject.Inject;

/**
 * Created by anchung on 10/26/2015.
 */
public final class TeeShirt implements Shirt {
    private String color;
    private int length;
    private int sleeveLength;

    @Inject
    private TeeShirt(@Parameter(Color.class) String color,
                       @Parameter(Length.class) int length,
                       @Parameter(SleeveLength.class) int sleeveLength){
        this.color = color;
        this.length = length;
        this.sleeveLength = sleeveLength;
    }

    public String getName() {
        return "T shirt";
    }

    public String getColor() {
        return this.color;
    }

    public int getLength() {
        return this.length;
    }

    public int getSleeveLength() {
        return this.sleeveLength;
    }
}
