/**
 * BSP training Copyright (C) 2010 - 2015
 */
package bsptraining.misc;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 * This runnable program demonstrates a table with a <b>fixed column</b>.<br>
 * Internally two tables are used:<br> -
 * <code>RowHeader</code> holds the <b>first</b> fixed column<br> -
 * <code>Table</code> holds <b>all</b> columns <b>except</b> the first fixed
 * one<br> The two tables share <b>one</b>
 * <code>TableColumnModel</code>.
 *
 * @author BSP
 */
public class FixTableMain extends JFrame {

   private static final long serialVersionUID = 1L;

   public static void main(String args[]) {
      FixTableMain fixTableMain = new FixTableMain();
   }

   public FixTableMain() {
      JScrollPane scroll = new JScrollPane();
      Table table = new Table();
      RowHeader rheader = new RowHeader(table);
      scroll.setRowHeaderView(rheader);
      scroll.setViewportView(table);
      scroll.add(rheader.getTableHeader(), ScrollPaneLayout.UPPER_LEFT_CORNER);
      add(scroll);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(400, 400);
      setVisible(true);
   }

   /**
    * This is the fixed header column
    */
   private class RowHeader extends JTable {

      private static final long serialVersionUID = 1L;

      RowHeader(JTable t) {
         // Remove all columns except the first
         setModel(t.getModel());
         TableColumnModel colModel = getColumnModel();
         int colCount = getColumnCount() - 1;
         for (int i = 0; i < colCount; i++) {
            removeColumn(colModel.getColumn(1));
         }

         setRowHeight(t.getRowHeight());
         getTableHeader().setReorderingAllowed(false);

         // give RowHeader the same sorter as Table
         setRowSorter(t.getRowSorter());
         setPreferredScrollableViewportSize(new Dimension(60, (int) t.getPreferredScrollableViewportSize().getHeight()));
      }
   }

   /**
    * This is the Table
    */
   private class Table extends JTable {

      private static final long serialVersionUID = 1L;
      private final String[] rowHeaders = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

      Table() {
         // Fill some data
         String[] columnHeader = new String[]{"Click", "1", "2", "3"};
         Object[][] data = new Object[10][4];
         for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
               if (j == 0) {
                  data[i][j] = rowHeaders[i];
               } else {
                  data[i][j] = (int) (Math.random() * 100) + "";
               }
            }
         }
         DefaultTableModel dm = new DefaultTableModel(data, columnHeader);
         setModel(dm);
         // Remove the first (fixed) column
         removeColumn(getColumnModel().getColumn(0));
         setRowSorter(new TableRowSorter<>(dm));
         setRowHeight(20);
         getTableHeader().setReorderingAllowed(true); // default
         setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      }
   }
}
