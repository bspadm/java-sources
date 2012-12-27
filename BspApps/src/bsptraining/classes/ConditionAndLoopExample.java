/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

public class ConditionAndLoopExample {

   public String ifExample(int number) {
      String msg;
      if (number == 0) {
         msg = "number = 0";
      } else if ((number >= 1) && (number < 10)) {
         msg = "0 < number < 10";
      } else {
         msg = "number < 0 oder number >= 10";
      }
      return msg;
   }

   public String switchExample(char choice) {
      String msg = "";
      switch (choice) {
         case 'A':
            msg = msg + "Ich bin in A reingelaufen.";
            break;
         case 'B':
            msg = msg + "Ich bin in B reingelaufen.";
         case 'C':
            msg = msg + "Ich bin in C reingelaufen.";
         case 'D':
            msg = msg + "Ich bin in D reingelaufen.";
            break;
         default:
            msg = msg + "Ich bin in default reingelaufen.";
      }
      return msg;
   }

   public void forExample(String name) {
      char[] chars = name.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         System.out.println("chars[" + i + "] = " + chars[i]);
      }
      // for each
      for (char c : chars) {
         System.out.println("ConditionAndLoopExample.forExample: " + c);
      }
   }

   public void whileExample(int loops) {
      int i = 0;
      while (i < loops) {
         if (i == 5) {
            System.out.println("ConditionAndLoopExample.whileExample: Don't want to loop for 5!");
            continue;
         }
         System.out.println("ConditionAndLoopExample.whileExample: Loop = " + i);
         if (i > 10) {
            System.out.println("ConditionAndLoopExample.whileExample: It's boring to loop further!");
            break;
            // return;
         }
         i++;
      }
   }

   public void doWhileExample(int loops) {
      int i = 0;
      do {
         System.out.println("ConditionAndLoopExample.whileExample: Loop = " + i);
         i++;
      } while (i < loops);
   }
}
