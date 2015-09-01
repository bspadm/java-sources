/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * Message service consumer.
 * @author jelsen
 */
public class MessageServiceConsumer implements Consumer {

   private final MessageService service;

   public MessageServiceConsumer(MessageService service) {
      this.service = service;
   }

   @Override
   public void processMessages(String msg, String rec) {
      //do some msg validation, manipulation logic etc
      service.sendMessage(msg, rec);
   }

}
