/**
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.graph;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements Shape to be an Ellipse.
 * @author jelsen
 */
public class Ellipse implements Shape {

   private final double axis_a;
   private final double axis_b;

   // Constructor
   public Ellipse(double a, double b) {
      this.axis_a = a;
      this.axis_b = b;
   }

   @Override
   public int getCorners() {
      return 0;
   }

   @Override
   public double getPerimeter() {
      return axis_a * axis_b * Math.PI;
   }

   @Override
   public double getArea() {
      return 10;
   }

   @Override
   public boolean isSymmetrical() {
      return true;
   }

   @Override
   public void draw(Graphics graphics, Color color) {
      graphics.setColor(color);
      graphics.drawOval(0, 0, (int) axis_a, (int) axis_b);
   }

   @Override
   public String getName() {
      return "Ellipse";
   }
}
