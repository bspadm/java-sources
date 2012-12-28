/**
 * BSP 2008
 */
package bsptraining.graph;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Interface Shape to be implemented in Circle etc. All derived classes must
 * implement these methods. This is useful for code standardisation.
 *
 * @author jelsen
 */
public interface Shape {

   /**
    * @return the corners
    */
   public int getCorners();

   /**
    * @return the perimeter
    */
   public double getPerimeter();

   /**
    * @return the area
    */
   public double getArea();

   /**
    * @return the symmetrical
    */
   public boolean isSymmetrical();

   /**
    * Draw the Shape on Graphics in Color
    *
    * @param graphics
    * @param color
    */
   public void draw(Graphics graphics, Color color);

   /**
    * @return the name
    */
   public String getName();
}
