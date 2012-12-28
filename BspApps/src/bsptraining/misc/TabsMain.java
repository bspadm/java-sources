/**
 * BSP training Copyright (C) 2008 - 2012
 */
package bsptraining.misc;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 * This runnable program builds MAX_TABS tab panes with two different
 * layouts.<br> Between the layouts can be toggled
 *
 * @author jelsen
 */
public class TabsMain extends JFrame {

   private static final long serialVersionUID = 5302235553414382349L;
   private static final int MAX_TABS = 24;

   public static void main(String args[]) {
      TabsMain tabsMain = new TabsMain();
   }

   public TabsMain() {
      super("Too Many Tabs Test"); // Constructor of JFrame
      setSize(200, 200);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Container contentPane = getContentPane();

      JTabbedPane wrapPane = new JTabbedPane();
      JTabbedPane scrollPane = new JTabbedPane();
      scrollPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
      for (int i = 1; i < MAX_TABS; i++) {
         String tab = "Tab #" + i;
         wrapPane.addTab(tab, new JLabel(tab));
         scrollPane.addTab(tab, new JLabel(tab));
      }
      JTabbedPane topPane = new JTabbedPane(JTabbedPane.RIGHT);
      topPane.addTab("Wrap Tabs", wrapPane);
      topPane.addTab("Scroll Tabs", scrollPane);
      contentPane.add(topPane);

      setVisible(true);
   }
}