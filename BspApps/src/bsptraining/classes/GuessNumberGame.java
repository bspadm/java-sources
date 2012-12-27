/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

import javax.swing.JOptionPane;

/**
 * This class demonstrates the random function and option panes.
 * @author jelsen
 */
public class GuessNumberGame {

   private int maxRandom;
   private static final int MAX_TRY = 10;

   public GuessNumberGame(int maxRandom) {
      this.maxRandom = maxRandom;
   }

   public void start() {
      int randomInt = (int) (Math.random() * maxRandom);
      int inputInt;
      int tryInt = 1;
      boolean guessed = false;
      do {
         String input = JOptionPane.showInputDialog("Guess a number between 0 and " + maxRandom + ". Try " + tryInt + "/" + MAX_TRY);
         try {
            if (input == null) {
               JOptionPane.showMessageDialog(null, "Abort", "Abort", JOptionPane.INFORMATION_MESSAGE);
               break;
            }
            inputInt = Integer.parseInt(input);
            if (inputInt == randomInt) {
               JOptionPane.showMessageDialog(null, "Right!", input, JOptionPane.ERROR_MESSAGE);
               guessed = true;
            } else if (inputInt > randomInt) {
               JOptionPane.showMessageDialog(null, "Value too large!", Integer.toString(inputInt), JOptionPane.ERROR_MESSAGE);
               guessed = false;
            } else {
               JOptionPane.showMessageDialog(null, "Value too small!", Integer.toString(inputInt), JOptionPane.ERROR_MESSAGE);
               guessed = false;
            }
            tryInt++;
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Value not numeric!", input, JOptionPane.ERROR_MESSAGE);
         }
      } while (tryInt < MAX_TRY && !guessed);
   }
}
