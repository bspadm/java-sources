/**
 * BSP 2008
 */
package bsptraining.graph;

/**
 * @author BSP
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
