/**
 * BSP 2008
 */
package bsptraining.graph;

import java.awt.Color;

public enum ColorEnum {
	RED(Color.red), GREEN(Color.green), BLUE(Color.blue), CYAN(Color.cyan), GRAY(
			Color.darkGray), PINK(Color.pink);

	private Color c;

	private ColorEnum(Color c) {
		this.c = c;
	}

	public Color getColor() {
		return this.c;
	}
}
