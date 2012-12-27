// BSP 2008

package bsptraining.strings;

public class StringsMain {
	static final long MAX = 20000;

	/**
	 * This runnable program concatenates and splits a string MAX times by three
	 * different methods.<br>
	 * The time for the action is printed out.<br>
	 * Demonstrates that the fastest method is StringBuilder.
	 * @author BSP
	 */
	public static void main(String[] args) {
		System.out.println("Test starting with " + MAX + " concats and splits...");
		stringTest();
	}

	private static void stringTest() {
		String[] stringArray;

		// Method 1: String (base class)
		String s1 = "";
		String s2;
		long t1 = System.currentTimeMillis();
		for (long l = 0; l < MAX; l++) {
			if (l == 0) {
				s2 = s1.concat("BSP");
			} else {
				s2 = s1.concat("+BSP");
			}
			s1 = s2;
		}
		long t2 = System.currentTimeMillis();
		stringArray = s1.split("\\+");
		System.out.println("Time for String: " + (t2 - t1) + " ms");

		// Method 2: StringBuffer (thread-save)
		StringBuffer stringBuffer = new StringBuffer("BSP");
		t1 = System.currentTimeMillis();
		for (long l = 0; l < MAX - 1; l++) {
			stringBuffer.append("+BSP");
		}
		t2 = System.currentTimeMillis();
		stringArray = stringBuffer.toString().split("\\+");
		System.out.println("Time for StringBuffer: " + (t2 - t1) + " ms");

		// Method 3: StringBuilder (not synchronized)
		StringBuilder stringBuilder = new StringBuilder("BSP");
		t1 = System.currentTimeMillis();
		for (long l = 0; l < MAX - 1; l++) {
			stringBuilder.append("+BSP");
		}
		t2 = System.currentTimeMillis();
		stringArray = stringBuilder.toString().split("\\+");
		System.out.println("Time for StringBuilder: " + (t2 - t1) + " ms");

	}

}
