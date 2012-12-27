/**
 * BSP 2008
 */

package bsptraining.graph;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements <code>Shape</code> to be an <code>Ellipse</code>
 *
 * @author BSP
 */

public class Rectangle implements Shape {
	private double a;
	private double b;

	// Constructor
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public int getCorners() {
		return 4;
	}

	public double getPerimeter() {
		return 2 * (a + b);
	}

	public double getArea() {
		return a * b;
	}

	public boolean isSymmetrical() {
		return true;
	}

	public void draw(Graphics graphics, Color color) {
		graphics.setColor(color);
		graphics.drawRect(0, 0, (int) a, (int) b);
	}

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
