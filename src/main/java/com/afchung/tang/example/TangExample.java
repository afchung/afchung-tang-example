package com.afchung.tang.example;

import com.afchung.tang.example.materials.Cotton;
import com.afchung.tang.example.materials.Material;
import com.afchung.tang.example.top.jacket.DownJacket;
import com.afchung.tang.example.top.jacket.HoodieJacket;
import com.afchung.tang.example.top.jacket.Jacket;
import com.afchung.tang.example.top.jacket.JacketConfiguration;
import com.afchung.tang.example.top.shirt.DressShirt;
import com.afchung.tang.example.top.shirt.Shirt;
import com.afchung.tang.example.top.shirt.ShirtConfiguration;
import com.afchung.tang.example.top.shirt.TeeShirt;
import org.apache.reef.tang.Configuration;
import org.apache.reef.tang.Configurations;
import org.apache.reef.tang.Injector;
import org.apache.reef.tang.Tang;
import org.apache.reef.tang.exceptions.BindException;
import org.apache.reef.tang.exceptions.InjectionException;

import java.io.IOException;

/**
 * This is an example of TANG, driven by selecting an outfit for the day.
 */
public final class TangExample {
  private static final String EXAMPLE_SEPARATOR = "%n---------------EXAMPLE %d---------------%n";
  private static final String DESC_SEPARATOR = "-----";

  public static void main(String[] args) throws InjectionException, IOException {
    final Configuration jacketConfig = JacketConfiguration.CONF
        .set(JacketConfiguration.COLOR, "Blue")
        .set(JacketConfiguration.LENGTH, 5)
        .set(JacketConfiguration.THICKNESS, 3)
        .build();

    firstExample(jacketConfig);
    System.in.read();

    secondExample(jacketConfig);
    System.in.read();

    thirdExample();
    System.in.read();

    final Configuration shirtConfig = ShirtConfiguration.CONF
        .set(ShirtConfiguration.COLOR, "White")
        .set(ShirtConfiguration.LENGTH, 5)
        .set(ShirtConfiguration.MATERIAL, Cotton.class)
        .build();

    fourthExample(shirtConfig);
    System.in.read();
    fifthExample(shirtConfig);
    System.in.read();

    sixthExample();
    System.in.read();
    seventhExample();
    System.in.read();
    eighthExample();
    System.in.read();
  }

  private static void printSeparator(int exNum, String description) {
    System.out.format(EXAMPLE_SEPARATOR, exNum);
    System.out.println(description);
    System.out.println(DESC_SEPARATOR);
  }

  private static void firstExample(final Configuration jacketConfig) throws InjectionException {
    printSeparator(1, "This example is a simple example of getting a hoodie jacket with the specified settings" +
        " in a jacket configuration.");

    final Injector injector = Tang.Factory.getTang().newInjector(jacketConfig);
    Jacket jacket;
    jacket = injector.getInstance(HoodieJacket.class);
    System.out.println("Jacket type is: " + jacket.getName());
    System.out.println("Jacket thickness is: " + jacket.getThickness());
    System.out.println("Jacket color is: " + jacket.getColor());
    System.out.println("Jacket length is: " + jacket.getTopLength());
  }

  private static void secondExample(final Configuration jacketConfig) throws InjectionException {
    printSeparator(2, "This example is a simple example of getting a jacket object with the specified settings" +
        " in a jacket configuration. This demonstrates the use of DefaultImplementation. We only specify that " +
        "we want an instance of Jacket and we get a down jacket, since down jacket is the DefaultImplementation" +
        " in the Jacket interface.");

    final Injector injector = Tang.Factory.getTang().newInjector(jacketConfig);

    final Jacket jacket = injector.getInstance(Jacket.class);
    System.out.println("Jacket type is: " + jacket.getName());
    System.out.println("Jacket thickness is: " + jacket.getThickness());
    System.out.println("Jacket color is: " + jacket.getColor());
    System.out.println("Jacket length is: " + jacket.getTopLength());
  }

  private static void thirdExample() {
    printSeparator(3,
        "This example is a simple example of trying to build a configuration without a required parameter.");

    try {
      ShirtConfiguration.CONF.build();
    } catch (BindException e) {
      System.out.println("Cannot create a shirt without the required parameter color!");
      e.printStackTrace();
    }
  }

  private static void fourthExample(final Configuration shirtConfig) throws InjectionException {
    printSeparator(4,
        "This example is a simple example of showing the instantiation of an inner Material interface in TeeShirt.");

    final Injector injector = Tang.Factory.getTang().newInjector(shirtConfig);
    final Shirt shirt = injector.getInstance(TeeShirt.class);
    System.out.println("Shirt type is: " + shirt.getName());
    System.out.println("Shirt color is: " + shirt.getColor());
    System.out.println("Shirt length is: " + shirt.getTopLength());
    System.out.println("Shirt material is: " + shirt.getMaterial());
  }

  private static void fifthExample(final Configuration shirtConfig) throws InjectionException {
    printSeparator(5,
        "This example is a simple example of showing that configurations are simply a mapping of named parameters" +
            " and interfaces to implementing class. The DressShirt class does not expose the Material in its" +
            " constructor, but when we get an instance of Material from the injector, we get the Material " +
            " specified in our configuration.");

    final Injector injector = Tang.Factory.getTang().newInjector(shirtConfig);

    // Dress shirt does not expose Material parameter in constructor. Disobeys so Material is Shiny.
    final Shirt shirt = injector.getInstance(DressShirt.class);
    System.out.println("Shirt type is: " + shirt.getName());
    System.out.println("Shirt color is: " + shirt.getColor());
    System.out.println("Shirt length is: " + shirt.getTopLength());
    System.out.println("Shirt material is: " + shirt.getMaterial());

    final Material material = injector.getInstance(Material.class);
    System.out.println("Directly getting Material from injector yields: " + material);
  }

  private static void sixthExample() {
    printSeparator(6,
        "This example is a simple example of showing that required parameters must be bound, even if" +
            " object to instantiate from the parameter is a set bound via bindSetEntry.");

    try {
      ClothesConfiguration.CONF.build();
    } catch (BindException e) {
      System.out.println("Cannot create an outfit without any top layers!");
      e.printStackTrace();
    }
  }

  private static void seventhExample() throws InjectionException {
    printSeparator(7, "This example is a simple example of binding an entry in a Set of Tops.");

    final Configuration clothesConfig = ClothesConfiguration.CONF
        .set(ClothesConfiguration.TOP_LAYER, DownJacket.class)
        .build();

    final Configuration jacketConfig = JacketConfiguration.CONF
        .set(JacketConfiguration.COLOR, "Yellow")
        .set(JacketConfiguration.LENGTH, 5)
        .set(JacketConfiguration.THICKNESS, 10)
        .build();

    final Injector injector = Tang.Factory.getTang().newInjector(Configurations.merge(clothesConfig, jacketConfig));
    MyOutfit outfit = injector.getInstance(MyOutfit.class);
    System.out.println(outfit);
  }

  private static void eighthExample() throws InjectionException {
    printSeparator(8, "This example is a simple example of binding multiple entries in a Set of Tops.");

    final Configuration clothesConfig = ClothesConfiguration.CONF
        .set(ClothesConfiguration.TOP_LAYER, HoodieJacket.class)
        .set(ClothesConfiguration.TOP_LAYER, TeeShirt.class)
        .build();

    final Configuration shirtConfig = ShirtConfiguration.CONF
        .set(ShirtConfiguration.COLOR, "Green")
        .set(ShirtConfiguration.LENGTH, 3)
        .build();

    final Configuration jacketConfig = JacketConfiguration.CONF
        .set(JacketConfiguration.COLOR, "Orange")
        .set(JacketConfiguration.LENGTH, 3)
        .set(JacketConfiguration.THICKNESS, 3)
        .build();

    final Injector injector = Tang.Factory.getTang().newInjector(Configurations.merge(clothesConfig, jacketConfig, shirtConfig));
    final MyOutfit outfit = injector.getInstance(MyOutfit.class);
    System.out.println(outfit);
  }
}
