package com.mex.gcm;


public class teste {
	public static void main (String[] args){
		
		SendPushGCM push = new SendPushGCM("AIzaSyDyc2tKYy4cLMwdxEqYQL8ZN34YhqOsJr8");
		push.Send("APA91bEVfyJGil8SxAJ8gEBvNPyf2shWxH9ju76zPS0EmEA5vBF1QuoM6kuVozPUbQBua1AdvHaX0Izbfi1UD_eij0", "teste", "testemsg", "3", "{token:10}");
		
	}
}
