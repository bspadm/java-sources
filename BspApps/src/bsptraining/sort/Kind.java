/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.sort;

/**
 * This class demonstrates Comparables on user-defined types.
 *
 * @author jelsen
 */
public class Kind implements Comparable<Kind> {

   private String vorname;
   private String name;
   private int alter;

   public Kind() {
   }

   public Kind(String vorname, String name, int alter) {
      this.vorname = vorname;
      this.name = name;
      this.alter = alter;
   }

   public String getName() {
      return vorname + " " + name;
   }

   public int getAlter() {
      return alter;
   }

   public void addAlter(int jahre) {
      alter += jahre;
   }

   @Override
   public String toString() {
      return vorname + " " + name + " " + alter;
   }

   @Override
   public int compareTo(Kind kind) {
      int cmp = Integer.valueOf(alter).compareTo(Integer.valueOf(kind.alter));
      if (cmp == 0) {
         int cmp2 = name.compareTo(kind.name);
         if (cmp2 == 0) {
            return vorname.compareTo(kind.vorname);
         } else {
            return name.compareTo(kind.name);
         }
      } else {
         return cmp;
      }
   }
}
