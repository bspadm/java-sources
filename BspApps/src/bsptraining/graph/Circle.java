/**
 * BSP 2008
 */
package bsptraining.graph;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements <code>Shape</code> to be a <code>Circle</code>
 *
 * @author BSP
 */
public class Circle implements Shape {
	private double radius;

	// Constructor
	public Circle(double radius) {
		this.radius = radius;
	}

   @Override
	public int getCorners() {
		return 0;
	}

   @Override
	public double getPerimeter() {
		double perimeter = radius * 2 * Math.PI;
		return perimeter;
	}

   @Override
	public double getArea() {
		double area = Math.pow(radius, 2) * Math.PI;
		return area;
	}

   @Override
	public boolean isSymmetrical() {
		return true;
	}

   @Override
	public void draw(Graphics graphics, Color color) {
		int i = (int) this.getDiameter();
		graphics.setColor(color);
		graphics.drawOval(0, 0, i, i);
	}

	public double getRadius() {
		return radius;
	}

   @Override
	public String getName() {
		return "Circle";
	}

	/**
	 * @return the diameter
	 */
	public double getDiameter() {
		return 2 * radius;
	}
}
