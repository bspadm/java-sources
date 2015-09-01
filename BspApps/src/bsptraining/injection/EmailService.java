/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * The email service implmentation.
 * @author jelsen
 */
public class EmailService implements MessageService {

   @Override
   public void sendMessage(String msg, String rec) {
      //logic to send email
      System.out.println("Email sent to " + rec + " with Message=" + msg);
   }

}