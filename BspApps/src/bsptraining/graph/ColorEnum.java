/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.graph;

import java.awt.Color;

/**
 * This class demonstrates an enumeration. Enumerations are in fact classes and
 * are typically defined in "real" classes.
 *
 * @author jelsen
 */
public enum ColorEnum {

   RED(Color.red),
   GREEN(Color.green),
   BLUE(Color.blue),
   CYAN(Color.cyan),
   GRAY(Color.darkGray),
   PINK(Color.pink);
   private Color c;

   private ColorEnum(Color c) {
      this.c = c;
   }

   public Color getColor() {
      return this.c;
   }
}
