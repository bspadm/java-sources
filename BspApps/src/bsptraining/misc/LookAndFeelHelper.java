package bsptraining.misc;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Helper class to set / reset a specific look and feel at runtime.
 * Tested look and feels only.
 * @author jelsen
 */
public class LookAndFeelHelper {
   /** The original look and feel. */
   private final static LookAndFeel originalLookAndFeel = UIManager.getLookAndFeel();
   /** Windows look and feel. (Default) */
   public static final String Windows = "Windows Classic";
   /** Metal look and feel. */
   public static final String Metal = "Metal";
   /** CDE look and feel. */
   public static final String CDE = "CDE/Motif";

   /**
    * Change look and feel on specific frame.
    */
   public static void changeLookAndFeel(String lookAndFeel, JFrame frame) {
      try {
         for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (lookAndFeel.equals(info.getName())) {
               //logger.trace("Changing look and feel to: " + info.getName());
               UIManager.setLookAndFeel(info.getClassName());
               SwingUtilities.updateComponentTreeUI(frame);
               frame.pack();
               break;
            } else {
               //logger.trace("No match: " + lookAndFeel + "<->" + info.getName());
            }
         }
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
         //logger.error("Could not set Look and Feel: " + lookAndFeel);
      }
   }

   /**
    * Reset look and feel on specific frame.
    */
   public static void resetLookAndFeel(JFrame frame) {
      try {
         UIManager.setLookAndFeel(originalLookAndFeel);
         SwingUtilities.updateComponentTreeUI(frame);
         frame.pack();
         //logger.warn("Original look and feel and frame restored.");
      } catch (UnsupportedLookAndFeelException ex) {
      }
   }

   /**
    * Reset look an feel for other frames which shall never be affected.
    * Call this before creating new frames.
    */
   public static void resetLookAndFeel() {
      if (UIManager.getLookAndFeel() != originalLookAndFeel) {
         try {
            UIManager.setLookAndFeel(originalLookAndFeel);
            //logger.warn("Original look and feel restored.");
         } catch (UnsupportedLookAndFeelException ex) {
         }
      }
   }
}
