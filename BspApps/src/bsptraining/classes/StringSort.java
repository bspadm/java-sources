/**
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.classes;

/**
 * This class demonstrates a simple sort algotithm (ripple-sort).
 *
 * @author jelsen
 */
public class StringSort {

   private final String[] unsorted;
   private final String[] sorted;

   public StringSort(String... strings) {
      this.unsorted = strings;
      this.sorted = new String[unsorted.length];
   }

   public String[] sort() {
      for (int i = 0; i < unsorted.length; i++) {
         for (int j = i + 1; j < unsorted.length; j++) {
            if (unsorted[j].compareToIgnoreCase(unsorted[i]) < 0) {
               String word = unsorted[i];
               unsorted[i] = unsorted[j];
               unsorted[j] = word;
            }
         }
         sorted[i] = unsorted[i];
      }
      return sorted;
   }

   public void output() {
      for (String sorted1 : sorted) {
         System.out.println(sorted1);
      }
   }
}
