/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * SMS service injector.
 * @author jelsen
 */
public class SMSServiceInjector implements MessageServiceInjector {

   @Override
   public Consumer getConsumer() {
      return new MessageServiceConsumer(new SMSService());
   }

}
