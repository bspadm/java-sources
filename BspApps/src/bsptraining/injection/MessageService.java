/*
 * BSP training Copyright (C) 2008 - 2015
 */
package bsptraining.injection;

/**
 * Message Service interface for all kind of messages (Email, SMS, ...)
 * To add a new service "New" simply create NewService & NewServiceInjector
 * @author jelsen
 */
public interface MessageService {

   void sendMessage(String msg, String rec);

}
