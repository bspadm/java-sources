/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

/**
 * This class demonstrates static data and methods and common String comparison.
 *
 * @author jelsen
 */
public class ObjectExample {

   public static int year;
   private String name = null;

   public ObjectExample(String name) {
      this.name = name;
   }

   public static void staticMethod(String arg) {
      System.out.println("Examples.staticMethod: " + arg + " in year " + ObjectExample.year);
   }

   public String echo(String arg) {
      System.out.println("Examples.objectMethod: Objekt = "
              + this
              + ", Argument = "
              + arg
              + " in year "
              + ObjectExample.year
              + " on Objectname "
              + this.name);
      String echo = this.name + ": " + name;
      return echo;
   }

   public void stringExample(String value1, String value2) {
      System.out.println("DatatypeExample.stringExample: Value 1 = " + value1 + ", Value 2 = " + value2);
      boolean b;
      b = (value1 == value2);
      System.out.println("DatatypeExample.stringExample: (value1 == value2): " + b);

      b = value1.equals(value2);
      System.out.println("DatatypeExample.stringExample: value1.equals(value2): " + b);

      b = value1.equalsIgnoreCase(value2);
      System.out.println("DatatypeExample.stringExample: value1.equalsIgnoreCase(value2): " + b);

      b = value1.endsWith(value2);
      System.out.println("DatatypeExample.stringExample: value1.endsWith(value2): " + b);

      b = value1.startsWith(value2);
      System.out.println("DatatypeExample.stringExample: value1.startsWith(value2): " + b);

      // A string is an object which is represented internally by a character array
      char[] chars = value1.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         System.out.println("chars[" + i + "] = " + chars[i]);
      }
   }

   class SubClass {
   }

   static class InnerClass {
   }
}
