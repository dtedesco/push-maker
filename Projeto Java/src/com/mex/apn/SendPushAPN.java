package com.mex.apn;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.relayrides.pushy.apns.ApnsEnvironment;
import com.relayrides.pushy.apns.PushManager;
import com.relayrides.pushy.apns.PushManagerConfiguration;
import com.relayrides.pushy.apns.util.ApnsPayloadBuilder;
import com.relayrides.pushy.apns.util.MalformedTokenStringException;
import com.relayrides.pushy.apns.util.SSLContextUtil;
import com.relayrides.pushy.apns.util.SimpleApnsPushNotification;
import com.relayrides.pushy.apns.util.TokenUtil;

public class SendPushAPN {
	String patchP12; //"ifideliza.p12"	
	String password; //"extreme@1"	
	
	public SendPushAPN(String p12,String pass) {
		super();
		patchP12 = p12;
		password = pass;
	}
	
	public boolean Send (String id, String title, String messageTxt, String msgcnt, String info) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, MalformedTokenStringException, InterruptedException, ParseException{
	
	final PushManager<SimpleApnsPushNotification> pushManager =
		    new PushManager<SimpleApnsPushNotification>(
		        ApnsEnvironment.getSandboxEnvironment(),
		        SSLContextUtil.createDefaultSSLContext(patchP12, password),
		        null, // Optional: custom event loop group
		        null, // Optional: custom ExecutorService for calling listeners
		        null, // Optional: custom BlockingQueue implementation
		        new PushManagerConfiguration(),
		        "iFideliza");

		pushManager.start();
		//"fec54834d2dfc03ab328233f6f8be7df24680296b3a895636ae76642c12c5708"
		final byte[] token = TokenUtil.tokenStringToByteArray(id);

			final ApnsPayloadBuilder payloadBuilder = new ApnsPayloadBuilder();

			payloadBuilder.setAlertBody(title+"\n"+messageTxt);
			payloadBuilder.setSoundFileName("ring-ring.aiff");
			payloadBuilder.setBadgeNumber(Integer.parseInt(msgcnt));
			
			JSONParser parser = new JSONParser();
			Map infos = (Map)parser.parse(info);
			Iterator iter = infos.entrySet().iterator();
			  while(iter.hasNext()){
			    Map.Entry entry = (Map.Entry)iter.next();
			    //System.out.println(entry.getKey() + "=>" + entry.getValue());
			    payloadBuilder.addCustomProperty(entry.getKey().toString(), entry.getValue().toString());
			  }
			final String payload = payloadBuilder.buildWithDefaultMaximumLength();

			pushManager.getQueue().put(new SimpleApnsPushNotification(token, payload));
		
			//pushManager.shutdown();
			return true;
	}
}
