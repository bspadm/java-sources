// BSP 2008
package bsptraining.classes;

public class MethodOverloadingExample {

	public String toString(Object obj) {
		return obj.toString();
	}

	public String toString(String s) {
		return s;
	}

	public String toString(int i) {
		return Integer.toString(i);
	}

	public String toString(double i) {
		return Double.toString(i);
	}

	public String toString(char c) {
		return Character.toString(c);
	}

	/**
	 * Variable parameter list
	 * @param objs is transferred internally into an array
	 * @return String
	 * @since Java 1.5
	 */
	public String toStringMethod(Object... objs) {
		String value = "";
		for (Object o : objs) {
			value = ("".equals(value)) ? value + toString(o) : value + " " + toString(o);
		}
		return value;
	}

}
