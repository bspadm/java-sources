/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * Message Service Application.
 * @author jelsen
 */
public class MessageServiceApp {

   public static void main(String[] args) {
      String msg = "Hello, Injection!";
      String email = "java@injection.com";
      String phone = "1234567890";
      MessageServiceInjector injector;
      Consumer consumer;

      //Send email
      injector = new EmailServiceInjector();
      consumer = injector.getConsumer();
      consumer.processMessages(msg, email);

      //Send SMS
      injector = new SMSServiceInjector();
      consumer = injector.getConsumer();
      consumer.processMessages(msg, phone);
   }

}
