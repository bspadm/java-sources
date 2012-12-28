/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

/**
 * This runnable class demonstrates base java functionality.
 * Testing of package "classes".
 *
 * @author jelsen
 */
public class ClassesMain {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      /*
       * Objects
       */
      ObjectExample.year = 2008;
      ObjectExample.staticMethod("Test");

      /*
       * Data types
       */
      DatatypeExample datatypeExample = new DatatypeExample("Elsen", "Jochen");
      datatypeExample.primitiveDatatypes();

      /*
       * Conditions and Loops
       */
      ConditionAndLoopExample conditionAndLoopExample = new ConditionAndLoopExample();
      conditionAndLoopExample.doWhileExample(5);
      conditionAndLoopExample.ifElseExample(1);

      /*
       * Overloading
       */
      MethodOverloadingExample methodOverloadingExample = new MethodOverloadingExample();
      long l = 1;
      String s = methodOverloadingExample.toString(l);
      System.out.println(s);
      System.out.println(methodOverloadingExample.toStringMethod("variable", "parameterliste", 1, 1.5));

      /*
       * Guess number game
       */
      GuessNumberGame guessNumberGame = new GuessNumberGame(25);
      guessNumberGame.start();

      /*
       * How to sort strings
       */
      StringSort stringSort = new StringSort("Wir", "lernen", "Strings", "zu", "sortieren");
      stringSort.sort();
      stringSort.output();

      /*
       * Exception handling
       */
      ExceptionExample e = new ExceptionExample();
      e.parseString("1");
      e.parseString("X"); // provoke an exception; program exits here

      /*
       * Public-Private example
       */
      System.out.println(PublicPrivateExample.publicVariable);
      // privateVariable would not work!
   }
}
