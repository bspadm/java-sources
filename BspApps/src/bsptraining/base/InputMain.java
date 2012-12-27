/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.base;

import java.util.Scanner;

/**
 * This runnable program demonstrates a simple input method via console
 *
 * @author jelsen
 */
public class InputMain {

   public static void main(String[] args) {
      String s = yourChoice();
      // note: print with new line
      System.out.println(s);
   }

   private static String yourChoice() {
      // note: strings use double quotes
      String inputString;
      String returnString = "";
      // note: characters use single quotes
      char choice = ' ';
      Scanner In = new Scanner(System.in);
      while (choice != '1' && choice != '2') {
         // note: print without new line
         System.out.print("Please choose: TRADE (1) or T24 (2) : ");
         inputString = In.next();
         choice = inputString.charAt(0);
         if (choice != '1' && choice != '2') {
            // note: output via standard error is printed red
            System.err.println("Wrong option!");
         }
      }
      // note: one line of code needs no brackets
      if (choice == '1') {
         returnString += "Your choice: TRADE";
      } else {
         returnString += "Your choice: T24";
      }
      // return value
      return returnString; // note: method exits here
   }
}
