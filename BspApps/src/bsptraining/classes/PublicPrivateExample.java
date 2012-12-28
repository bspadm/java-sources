/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

/**
 * This class shows the different access levels of variables and methods
 *
 * @author jelsen
 */
public class PublicPrivateExample {
   // note: warning "never read"

   private static int privateVariable = 1;
   // note: warnings can be suppressed (eclipse notation)
   @SuppressWarnings("unused")
   private static int unusedVariable = 0;
   protected static int protectedVariable = 2;
   public static int publicVariable = 3;

   // note: warning "never used"
   private void unaccessableMethod() {
      System.out.println("ObjectExample.unaccessableMethod: ");
   }

   // note: no warning because can be used from outside
   protected void protectedMethod() {
      System.out.println("ObjectExample.protectedMethod: ");
   }

   void packagePrivateMethod() {
      System.out.println("ObjectExample.packagePrivateMethod: ");
   }

   public void publicMethod() {
      System.out.println("ObjectExample.publicMethod: ");
   }
}
