/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * Email service injector.
 * @author jelsen
 */
public class EmailServiceInjector implements MessageServiceInjector {

   @Override
   public Consumer getConsumer() {
      return new MessageServiceConsumer(new EmailService());
   }

}
