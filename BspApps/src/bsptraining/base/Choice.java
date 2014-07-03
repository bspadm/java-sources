/**
 * BSP training Copyright (C) 2008 - 2014
 */
package bsptraining.base;

import java.util.Scanner;

/**
 * This runnable program demonstrates:<br>
 * - a simple input method via console<br>
 * - returning values to the shell<br>
 * @author jelsen
 */
public class Choice {

   private static final String END = "END";
   private static final String LOOP = "LOOP";

   public static void main(String[] args) {
      if (!yourChoice().equals(END)) {
         System.exit(0); // This means: LOOP for the shell
      } else {
         System.exit(9); // This means: END for the shell
      }
   }

   private static String yourChoice() {
      // note: strings use double quotes
      String inputString;
      String returnString;
      // note: characters use single quotes
      char choice = ' ';
      Scanner input = new Scanner(System.in);
      while (choice != '1' && choice != '2') {
         // note: print without new line
         System.out.print("Please choose: " + END + " (1) or " + LOOP + " (2) : ");
         inputString = input.next();
         choice = inputString.charAt(0);
         if (choice != '1' && choice != '2') {
            // note: output via standard error is printed red
            System.err.println("Wrong option!");
         }
      }
      if (choice == '1')  // note: brackets are optional for one-line-code
         returnString = END;
      else
         returnString = LOOP;

      // note: print with new line on the console
      System.out.println(returnString);
      // return value
      return returnString; // note: method exits here
   }
}
