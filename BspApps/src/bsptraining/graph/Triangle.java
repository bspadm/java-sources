/**
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.graph;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements Shape to be a Triangle.
 * @author jelsen
 */
public class Triangle implements Shape {

   private final double a;
   private final double height_a;

   // Constructor
   public Triangle(double a, double height_a) {
      this.a = a;
      this.height_a = height_a;
   }

   @Override
   public int getCorners() {
      return 3;
   }

   @Override
   public double getPerimeter() {
      return 0;
   }

   @Override
   public double getArea() {
      return 0.5 * a * height_a;
   }

   @Override
   public boolean isSymmetrical() {
      return true;
   }

   @Override
   public void draw(Graphics graphics, Color color) {
      final int[] x = new int[this.getCorners()];
      final int[] y = new int[this.getCorners()];
      x[0] = 0;
      y[0] = 0;
      x[1] = 0;
      y[1] = (int) height_a;
      x[2] = (int) a;
      y[2] = (int) height_a;
      graphics.setColor(color);
      graphics.drawPolygon(x, y, this.getCorners());
   }

   @Override
   public String getName() {
      return "Triangle";
   }
}
