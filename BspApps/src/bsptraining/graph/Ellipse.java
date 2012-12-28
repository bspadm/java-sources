/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.graph;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements
 * <code>Shape</code> to be an
 * <code>Ellipse</code>
 *
 * @author jelsen
 */
public class Ellipse implements Shape {

   private double halbachse_a;
   private double halbachse_b;

   // Constructor
   public Ellipse(double a, double b) {
      this.halbachse_a = a;
      this.halbachse_b = b;
   }

   @Override
   public int getCorners() {
      return 0;
   }

   @Override
   public double getPerimeter() {
      return halbachse_a * halbachse_b * Math.PI;
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
      graphics.drawOval(0, 0, (int) halbachse_a, (int) halbachse_b);
   }

   @Override
   public String getName() {
      return "Ellipse";
   }
}
