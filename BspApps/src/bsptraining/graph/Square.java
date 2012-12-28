/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.graph;

/**
 * Square is a special rectangle with even sides. This fact is used here with
 * the key word "extends". The super constructor (of Rectangle) is called with
 * width and height equal.
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
