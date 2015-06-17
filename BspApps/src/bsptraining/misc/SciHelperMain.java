/**
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.misc;

/**
 * If m is less than 10^-3 or greater than or equal to 10^7, then it is
 * represented in so-called "computerized scientific notation." Let n be the
 * unique integer such that 10n <= m < 10n+1; then let a be the mathematically
 * exact quotient of m and 10n so that 1 <= a < 10. The magnitude is then
 * represented as the integer part of a, as a single decimal digit, followed by
 * '.' ('\u002E'), followed by decimal digits representing the fractional part
 * of a, followed by the letter 'E' ('\u0045'), followed by a representation of
 * n as a decimal integer, as produced by the method Integer.toString(int).
 *
 * @author jelsen
 */
public class SciHelperMain {

   public static void main(String[] args) {
      Double d = -0.0000001;
      System.out.println(handleLargeNumbers(d));
   }

   /**
    * Convenience method to handle large numbers.
    * @param o the parameter which might be a large number
    * @return the parameter as string
    */
   public static String handleLargeNumbers(Object o) {
      if (o instanceof Double)
         return sci2normal(o.toString());
      else
         return o.toString();
   }

   /**
    * Convert computerized scientific notation to normal notation.<br>
    * Examples:<br>
    * 9.24E7=92400000<br>
    * 1.1269580767E8=112695807.67<br>
    * 1.0E-7=-0.0000001<br>
    * @param m the string in computerized scientific notation
    * @return the string in normal notation
    */
   private static String sci2normal(String m) {
      if (!m.contains("E"))
         return m;
      String esplit[] = m.split("E");
      String left = esplit[0];
      String[] dotsplit = left.split("\\.");
      String returnDigit = dotsplit[0];
      String returnNumber = dotsplit[1];
      Integer digits = returnNumber.length();
      Integer expo = new Integer(esplit[1]);
      Integer zeroes;
      if (expo > 0)
         zeroes = expo - digits;
      else
         zeroes = expo + digits;
      String returnReal;
      if (zeroes > 0)
         returnReal = returnDigit + rpad0(returnNumber, zeroes);
      else if (zeroes == 0)
         returnReal = returnDigit + returnNumber;
      else {
         String returnFraction;
         if (expo > 0) {
            returnFraction = returnNumber.substring(expo);
            returnNumber = returnNumber.substring(0, expo);
            returnReal = returnDigit + returnNumber + "." + returnFraction;
         } else {
            String sign = "";
            if (returnDigit.startsWith("-")) {
               sign = "-";
               returnDigit = returnDigit.substring(1);
            }
            returnFraction = lpad0(returnDigit, Math.abs(zeroes));
            if (returnNumber.equals("0"))
               returnNumber = "";
            returnReal = sign + "0." + returnFraction + returnNumber;
         }
      }
      System.out.println(m + "=" + returnReal);
      return returnReal;
   }

   private static String rpad0(String s, int count) {
      StringBuffer sb = new StringBuffer(count);
      for (int i = 0; i < count; i++) {
         sb.append("0");
      }
      s += sb;
      return s;
   }

   private static String lpad0(String s, int count) {
      StringBuilder sb = new StringBuilder(count);
      for (int i = 0; i < count; i++) {
         sb.append("0");
      }
      sb.append(s);
      return sb.toString();
   }

}
