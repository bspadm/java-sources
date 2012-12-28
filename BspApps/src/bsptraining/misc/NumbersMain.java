/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.misc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This runnable program demonstrates some ways to format numbers
 *
 * @author jelsen
 */
public class NumbersMain {

   public static void main(String args[]) {
      numbers();
      strings();
      format();
      date();
   }

   private static void numbers() {
      // Double always have a decimal point
      double d = 1;
      System.out.println("d [" + d + "]");
      // Manually format an ISO date
      String s1 = "20081103";
      String s2 = s1.substring(0, 4) + "-" + s1.substring(4, 6) + "-" + s1.substring(6, 8);
      System.out.println(s2);
   }

   private static void strings() {
      // Replace heading space by 0
      String s = " 809";
      s = s.trim();
      if (s.length() == 3) {
         s = "0" + s;
      }
      System.out.println(s);
   }

   private static void format() {
      // Decimal point is comma
      // strike = exerPrc / 10 ^ priceDps
      BigDecimal exerPrc = new BigDecimal(1234);
      BigDecimal priceDps = new BigDecimal(1);
      BigDecimal ten = new BigDecimal(10);
      BigDecimal result = exerPrc.divide(ten.pow(priceDps.intValue()));
      DecimalFormat df = new DecimalFormat();
      String strike = df.format(result).replace(".", ",");
      System.out.println("result [" + result + "] strike [" + strike + "]");
      int i = 0;
      DecimalFormat z = new DecimalFormat("Z");
      System.out.println("No zero, please: " + z.format(i));
   }

   private static void date() {
      // Display current date and time
      // Note that in java both is calculated from time
      Calendar cal = Calendar.getInstance();
      SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
      System.out.println(formater.format(cal.getTime()).toString());
      formater = new SimpleDateFormat("HH:mm:ss");
      System.out.println(formater.format(cal.getTime()).toString());
   }
}