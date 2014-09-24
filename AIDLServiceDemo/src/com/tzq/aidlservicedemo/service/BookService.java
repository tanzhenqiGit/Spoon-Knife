package com.tzq.aidlservicedemo.service;


import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.tzq.aidlservicedemo.aidl.IBook;

@SuppressLint("NewApi")
public class BookService extends Service {
	private String TAG = "aidl";
	private String[] bookNames = {
			"Java编程思想",
			"设计模式",
			"Android开发设计",
	};
	private IBinder mIBinder = new BookBinder();
	
	public String queryBookName(int bookNo) 
	{
		if ((bookNo > 0) && (bookNo <= bookNames.length)) {
			Log.d(TAG,"queryBook is called");
			return bookNames[bookNo - 1];
		}
		return null;
	}
	
	private class BookBinder extends IBook.Stub {

		@Override
		public String queryBook(int bookNo) throws RemoteException {
			Log.d(TAG,"queryBook no:"+ bookNo);
			return queryBookName(bookNo);
		}
		
	}
	
	
	@Override
	protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService dump");
		super.dump(fd, writer, args);
	}


	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}


	@Override
	public void onCreate() {
		// TODO Auto-generated method stub		
		Log.d(TAG,"BookService onCreate");
		super.onCreate();
	}


	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onDestroy");
		super.onDestroy();
	}


	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onLowMemory");
		super.onLowMemory();
	}


	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onRebind");
		super.onRebind(intent);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}


	@Override
	public void onTaskRemoved(Intent rootIntent) {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onStartCommand");
		super.onTaskRemoved(rootIntent);
	}



	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d(TAG,"BookService onUnbind");
		return super.onUnbind(intent);
	}


	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d(TAG,"service onBind");
		return mIBinder;
	}

}
