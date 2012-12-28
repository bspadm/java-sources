/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.classes;

/**
 * This class demonstrates constants and variables.
 *
 * @author jelsen
 */
public class DatatypeExample {

   /**
    * Constant values are defined by the key word <b>final</b>. The "const" key
    * word is not used and cannot be used. Per convention, constant values
    * <i>should</i> be defined in capital letters. The also <i>should</i> be
    * defined at first.
    */
   public static final String CONSTANT_VALUE = "CONSTANT_VALUE";
   private String name;
   private String vorname;

   public DatatypeExample(String name) {
      // Constructor (the name equals the class name)
      this.name = name;
   }

   public DatatypeExample(String name, String vorname) {
      this(name);
      this.vorname = vorname;
   }

   public void primitiveDatatypes() {
      System.out.println("Hallo, " + vorname + " " + name + "!");

      // There are no unsigned primitive numeric data types in java
      // integer example
      int i = 5;
      System.out.println("DatatypeExample.primitiveDatatypes: i = " + i);
      System.out.println("DatatypeExample.primitiveDatatypes: i = " + i++);
      System.out.println("DatatypeExample.primitiveDatatypes: i = " + ++i);
      i = i / 2;
      System.out.println("DatatypeExample.primitiveDatatypes: i = " + i);

      // double example
      double d = 5.4;
      System.out.println("DatatypeExample.primitiveDatatypes: d = " + d);
      d++;
      System.out.println("DatatypeExample.primitiveDatatypes: d = " + d);
      d = d / i;
      System.out.println("DatatypeExample.primitiveDatatypes: d = " + d);

      // byte, short, long, float usage is equally

      // character example
      char c = 'M';
      System.out.println("DatatypeExample.primitiveDatatypes: c = " + c);
      c++;
      System.out.println("DatatypeExample.primitiveDatatypes: c = " + c);
      i = (int) c;
      System.out.println("DatatypeExample.primitiveDatatypes: c = " + c + ", i = " + i);

      // Boolean are always "true" or "false"
      // C/C++ logic with 0 and 1 does not exist in java
      boolean b = true;
      System.out.println("DatatypeExample.primitiveDatatypes: b = " + b);
      b = (i == 1);
      System.out.println("DatatypeExample.primitiveDatatypes: b = " + b);
      b = (i > 1);
      System.out.println("DatatypeExample.primitiveDatatypes: b = " + b);
   }
}
