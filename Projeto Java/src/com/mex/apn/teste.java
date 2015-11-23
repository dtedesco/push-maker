package com.mex.apn;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.json.simple.parser.ParseException;

import com.relayrides.pushy.apns.ApnsEnvironment;
import com.relayrides.pushy.apns.PushManager;
import com.relayrides.pushy.apns.PushManagerConfiguration;
import com.relayrides.pushy.apns.util.ApnsPayloadBuilder;
import com.relayrides.pushy.apns.util.MalformedTokenStringException;
import com.relayrides.pushy.apns.util.SSLContextUtil;
import com.relayrides.pushy.apns.util.SimpleApnsPushNotification;
import com.relayrides.pushy.apns.util.TokenUtil;

public class teste {

	public static void main(String[] args) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, MalformedTokenStringException, InterruptedException, ParseException {
		// TODO Auto-generated method stub
		SendPushAPN apn = new SendPushAPN("ifideliza.p12", "extreme@1");
		apn.Send("fec54834d2dfc03ab328233f6f8be7df24680296b3a895636ae76642c12c5708", "Teste", "Envio de Notificação", "2", "{\"token\":\"123\",\"type\":\"transferSucess\"}");
	}

}
