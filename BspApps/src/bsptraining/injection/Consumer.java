/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * Service consumer interface for consumer classes.
 * @author jelsen
 */
public interface Consumer {

   void processMessages(String msg, String rec);

}
