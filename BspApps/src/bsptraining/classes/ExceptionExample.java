/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

/**
 * @author jelsen
 */
public class ExceptionExample {

   public int parseString(String stringAsNumber) throws NumberFormatException {
      try {
         int number = Integer.parseInt(stringAsNumber);
         return number;
      } catch (NumberFormatException e) {
         e.printStackTrace();
         throw e;
      } finally {
         System.out.println("ExceptionExample.parseString: Parsing done!");
      }
   }
}
