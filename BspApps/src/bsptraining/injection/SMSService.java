/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * The SMS service implementation.
 * @author jelsen
 */
public class SMSService implements MessageService {

   @Override
   public void sendMessage(String msg, String rec) {
      //logic to send SMS
      System.out.println("SMS sent to " + rec + " with Message=" + msg);
   }

}
