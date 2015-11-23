package com.mex.gcm;

import java.io.IOException;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.sun.xml.internal.ws.util.StringUtils;


public class SendPushGCM {
	String GCM_API_KEY;
	
	public SendPushGCM(String gCM_API_KEY) {
		super();
		GCM_API_KEY = gCM_API_KEY;
	}

	public boolean Send (String id, String title, String messageTxt, String msgcnt, String info){
		//final String GCM_API_KEY = "AIzaSyDyc2tKYy4cLMwdxEqYQL8ZN34YhqOsJr8";
		    final int retries = 3;
		    final String notificationToken = id;
		    Sender sender = new Sender(GCM_API_KEY);
		    Builder message  = new Message.Builder();
		    message.addData("title", title);
		    message.addData("message", messageTxt);
		    message.addData("msgcnt", msgcnt);
		    message.addData("info", info);
		    Message msg = message .build();

		    try {
		                Result result = sender.send(msg, notificationToken, retries);

		               // if (String.isEmpty(result.getErrorCodeName())) {
		                    //logger.debug("GCM Notification is sent successfully");
		                  //  return true;
		                if(result.getErrorCodeName()==null){
		                	//System.out.println("sucess");
		                	return true;
		                }
		               // }

		                System.out.println("Error occurred while sending push notification :" + result.getErrorCodeName());
		                
		    } catch (InvalidRequestException e) {
		                System.out.println("Invalid Request");
		    } catch (IOException e) {
		                System.out.println("IO Exception");
		    }
		    return false;
	}
}
