/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.base;

/**
 * This runnable program shows how to evaluate command line parameters.
 *
 * @author jelsen
 */
public class ArgMain {

   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("No Parameters");
      } else {
         System.out.println(args.length + " Parameters:");
         for (int i = 0; i < args.length; i++) {
            System.out.print(i == 0 ? args[i] : " " + args[i]);
         }
         System.out.println();
      }
   }
}
