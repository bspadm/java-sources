/**
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.graph;

/**
 * Square is a Rectangle with even sides. This is used here with the key word
 * "extends". The super constructor (of Rectangle) is called with width and
 * height equal.
 *
 * @author jelsen
 */
public class Square extends Rectangle {

   public Square(double a) {
      super(a, a);
   }

   @Override
   public String getName() {
      return "Square";
   }
}
