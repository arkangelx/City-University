package com.informatics.finals.threads;

import android.util.Log;



public class XmlThread extends Thread{
	private int PENDING=0;
	private int STARTED=1;
	private int FINISHED=2;
	private static String TAG = "XmlThread";
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Log.d(TAG,"Run in thread invoked"+this.toString());
		super.run();
	}

	
	private int getStatus(){
	return 0;
	}
}
