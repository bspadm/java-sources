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
public class Rectangle implements Shape {

   private final double a;
   private final double b;

   // Constructor
   public Rectangle(double a, double b) {
      this.a = a;
      this.b = b;
   }

   @Override
   public int getCorners() {
      return 4;
   }

   @Override
   public double getPerimeter() {
      return 2 * (a + b);
   }

   @Override
   public double getArea() {
      return a * b;
   }

   @Override
   public boolean isSymmetrical() {
      return true;
   }

   @Override
   public void draw(Graphics graphics, Color color) {
      graphics.setColor(color);
      graphics.drawRect(0, 0, (int) a, (int) b);
   }

   @Override
   public String getName() {
      return "Rectangle";
   }

   /**
    * @return the diagonal
    */
   public double getDiagonal() {
      return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
   }
}
