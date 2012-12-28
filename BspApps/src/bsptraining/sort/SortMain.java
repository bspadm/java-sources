/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.sort;

import java.util.*;

/**
 * This runnable program shows different sorting methods<br> The time for
 * sorting is printed out<br> It also demonstrates random numbers 6 out of 49
 *
 * @author BSP
 */
public class SortMain {

   /**
    * @param args
    */
   public static void main(String[] args) {
      Kind[] kindArray = fillKinder();
      comparableExample(kindArray);
      listExample(kindArray);
      sortedSetExample(kindArray);
      lotto();
   }

   private static Kind[] fillKinder() {
      // Define an array of classes
      // This is the java-way to get a structured array
      Kind[] kindArray = new Kind[5];
      kindArray[0] = new Kind("Susi", "Mayer", 11);
      kindArray[1] = new Kind("Otto", "Mayer", 9);
      kindArray[2] = new Kind("Otto", "Schmitt", 9);
      kindArray[3] = new Kind("Emil", "Bauer", 11);
      kindArray[4] = new Kind("Emil", "Bauer", 11); // Duplicate
      return kindArray;
   }

   private static void comparableExample(Kind[] kindArray) {
      // Sort the class via Comparable (Duplicates OK)
      long t1 = System.currentTimeMillis();
      Arrays.sort(kindArray);
      long t2 = System.currentTimeMillis();
      System.out.println("Sort via Comparable in ms: " + (t2 - t1));
      System.out.println(Arrays.toString(kindArray));
   }

   private static void listExample(Kind[] kindArray) {
      // Create the list (Duplicates OK)
      List<Kind> list = new LinkedList<Kind>();
      list.addAll(Arrays.asList(kindArray));
      // Get the number of elements in the list
      int size = list.size();
      System.out.println("Number of elements in List: " + size);
      // Sort the list
      long t1 = System.currentTimeMillis();
      Collections.sort(list);
      long t2 = System.currentTimeMillis();
      System.out.println("Sort via List in ms: " + (t2 - t1));
      // Retrieving the element at the front and end of the list
      Kind lastKind = list.get(list.size() - 1);
      Kind firstKind = list.get(0);
      System.out.println("First: " + firstKind.toString() + " Last: "
              + lastKind.toString());
      // Increase the age of each child
      for (Kind k : list) {
         k.addAlter(1);
      }
      System.out.println(Arrays.toString(kindArray));
   }

   private static void sortedSetExample(Kind[] kindArray) {
      SortedSet<Kind> sortedSet = new TreeSet<Kind>();
      sortedSet.addAll(Arrays.asList(kindArray));
      System.out.println(Arrays.toString(kindArray));
      for (Kind k : sortedSet) {
         k.addAlter(-1);
      }
      System.out.println(Arrays.toString(kindArray));
   }

   private static void lotto() {
      List<Integer> allNumbers = new ArrayList<Integer>(49);
      for (int i = 0; i < 49; i++) {
         allNumbers.add(i);
      }
      Collections.shuffle(allNumbers);
      List<Integer> drawnNumbers = new ArrayList<Integer>(6);
      for (int i = 0; i < 6; i++) {
         drawnNumbers.add(allNumbers.get(i));
      }
      Collections.sort(drawnNumbers);
      System.out.println("6 out of 49: " + drawnNumbers);
   }
}
