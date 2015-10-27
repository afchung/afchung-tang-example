package com.afchung.tang.example;

import com.afchung.tang.example.top.jacket.DownJacket;
import com.afchung.tang.example.top.jacket.HoodieJacket;
import com.afchung.tang.example.top.jacket.Jacket;
import com.afchung.tang.example.top.jacket.JacketConfiguration;
import com.afchung.tang.example.top.shirt.ShirtConfiguration;
import com.afchung.tang.example.top.shirt.TeeShirt;
import org.apache.reef.tang.Configuration;
import org.apache.reef.tang.Configurations;
import org.apache.reef.tang.Injector;
import org.apache.reef.tang.Tang;
import org.apache.reef.tang.exceptions.BindException;
import org.apache.reef.tang.exceptions.InjectionException;

/**
 * Hello world!
 *
 */
public final class TangExample {
    public static void main(String[] args ) {
        Configuration jacketConfig = JacketConfiguration.CONF
                .set(JacketConfiguration.COLOR, "Blue")
                .set(JacketConfiguration.LENGTH, 5)
                .set(JacketConfiguration.THICKNESS, 3)
                .build();

        Injector injector = Tang.Factory.getTang().newInjector(jacketConfig);
        Jacket jacket = null;
        try {
            jacket = injector.getInstance(HoodieJacket.class);
        } catch (InjectionException e) {
        }

        if (jacket == null) {
            throw new NullPointerException("Did not expect jacket to be null.");
        }

        System.out.println("1st jacket type is: " + jacket.getName());
        System.out.println("1st jacket thickness is: " + jacket.getThickness());
        System.out.println("1st jacket color is: " + jacket.getColor());
        System.out.println("1st jacket length is: " + jacket.getLength());

        injector = Tang.Factory.getTang().newInjector(jacketConfig);
        try {
            jacket = injector.getInstance(Jacket.class);
        } catch (InjectionException e) {
        }

        if (jacket == null) {
            throw new NullPointerException("Did not expect jacket to be null.");
        }

        System.out.println("2nd jacket type is: " + jacket.getName());
        System.out.println("2nd jacket thickness is: " + jacket.getThickness());
        System.out.println("2nd jacket color is: " + jacket.getColor());
        System.out.println("2nd jacket length is: " + jacket.getLength());

        Configuration clothesConfig;
        try {
             clothesConfig = ClothesConfiguration.CONF.build();
        } catch (BindException e){
            System.out.println("Cannot create an outfit without any top layers!");
        }

        clothesConfig = ClothesConfiguration.CONF
                .set(ClothesConfiguration.TOP_LAYER, DownJacket.class)
                .build();

        injector = Tang.Factory.getTang().newInjector(Configurations.merge(clothesConfig, jacketConfig));
        try {
            MyOutfit outfit = injector.getInstance(MyOutfit.class);
            System.out.println(outfit);
        } catch (InjectionException e) {
        }

        Configuration shirtConfig;
        try {
            shirtConfig = ShirtConfiguration.CONF.build();
        } catch (BindException e){
            System.out.println("Cannot create a shirt without the required parameter color!");
        }

        clothesConfig = ClothesConfiguration.CONF
                .set(ClothesConfiguration.TOP_LAYER, HoodieJacket.class)
                .set(ClothesConfiguration.TOP_LAYER, TeeShirt.class)
                .build();

        shirtConfig = ShirtConfiguration.CONF
                .set(ShirtConfiguration.COLOR, "Green")
                .set(ShirtConfiguration.SLEEVE_LENGTH, 50)
                .set(ShirtConfiguration.LENGTH, 3)
                .build();

        injector = Tang.Factory.getTang().newInjector(Configurations.merge(clothesConfig, jacketConfig, shirtConfig));
        try {
            MyOutfit outfit = injector.getInstance(MyOutfit.class);
            System.out.println(outfit);
        } catch (InjectionException e) {
        }
    }
}
