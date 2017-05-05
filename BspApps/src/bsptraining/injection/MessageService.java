/*
 * BSP training Copyright (C) 2008 - 2017
 */
package bsptraining.injection;

/**
 * Message Service interface for all kind of messages (Email, SMS, ...)
 * To add a new service "New" simply create "New"Service & "New"ServiceInjector
 * @author jelsen
 */
public interface MessageService {

   void sendMessage(String msg, String rec);

}
