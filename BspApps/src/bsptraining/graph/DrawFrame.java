/**
 * BSP 2008
 */
package bsptraining.graph;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <code>DrawFrame</code>
 * is an example drawing class with exit option.<br>
 * It draws some simple geometrical shapes.
 * @author BSP
 */
public class DrawFrame extends Frame {
	private static final long serialVersionUID = 1L;

	protected static class DrawArea extends Panel {
		private static final long serialVersionUID = 1L;
		// These set the size of the drawing area.
		private final static int MY_WIDTH = 300;
		private final static int MY_HEIGHT = 300;

		/**
		 * Does the actual drawing.
		 */
      @Override
		public void paint(Graphics g) {
			ColorEnum[] col = ColorEnum.values();
			Shape[] shapes = new Shape[5];
			shapes[0] = new Circle(75);
			shapes[1] = new Ellipse(10, 20);
			shapes[2] = new Rectangle(100, 50);
			shapes[3] = new Square(30);
			shapes[4] = new Triangle(150, 125);
			for (int i = 0; i < shapes.length; i++) {
				System.out.println(shapes[i].getName() + "-Area: " + shapes[i].getArea());
				if (shapes[i] instanceof Circle) {
					Circle c = (Circle) shapes[i];
					System.out.println("Radius: " + c.getRadius());
				}
				if (shapes[i] instanceof Square) {
					Square r = (Square) shapes[i];
					System.out.println("Diagonale: " + r.getDiagonal());
				}
				if (shapes[i] instanceof Rectangle) {
					if (!(shapes[i] instanceof Square)) {
					}
				}
				shapes[i].draw(g, col[i].getColor());
			}
		}

		/**
		 * Makes sure that the window drawing area has the right size.
		 */
      @Override
		public Dimension getPreferredSize() {
			return new Dimension(MY_WIDTH, MY_HEIGHT);
		}
	}

	/**
	 * Creates a new window frame.
	 */
	public DrawFrame(String name) {
		super(name);
	}

	/**
	 * Terminates the program when the user wants to quit.
	 */
	private static void quit() {
		System.exit(0);
	}

	/**
	 * Sets everything up and displays the drawing window.
	 */
	public static void showFrame() {
		// Create the window frame
		DrawFrame frame = new DrawFrame("Shapes");
		// Create the contents of the frame. The top (or Center)
		// part is the drawing area. The bottom (or South) strip
		// holds a quit button.
		DrawArea drawing = new DrawArea();
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new BorderLayout());
		Button quitButton = new Button("Quit");
		buttonPanel.add("Center", quitButton);
		frame.setLayout(new BorderLayout());
		frame.add("Center", drawing);
		frame.add("South", buttonPanel);
		// The event listeners are set up here to enable the
		// program to respond to events.
		quitButton.addActionListener(new ActionListener() {
         @Override
			public void actionPerformed(ActionEvent evt) {
				quit();
			}
		});
		frame.addWindowListener(new WindowAdapter() {
         @Override
			public void windowClosing(WindowEvent evt) {
				quit();
			}
		});
		frame.pack();
		frame.setVisible(true);
	}
}
