/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * Message Service Injector interface that returns the Consumer class.
 * @author jelsen
 */
public interface MessageServiceInjector {

   public Consumer getConsumer();

}
