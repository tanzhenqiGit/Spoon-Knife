package com.tzq.aidlservicedemo;

import com.tzq.aidlservicedemo.aidl.IBook;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String TAG = "aidl";
	private EditText numberText;
	private TextView resultView;
	private Button query;
	private IBook bookQuery;
	private BookConnect bookConn = new BookConnect();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberText = (EditText)findViewById(R.id.number);
		resultView = (TextView)findViewById(R.id.resultView);
		query = (Button)findViewById(R.id.query);
		Intent service = new Intent("com.tzq.aidlservicedemo.service.BookService");
		bindService(service, bookConn, BIND_AUTO_CREATE);
		
		if (query == null) {
			Log.d(TAG,"query button == null");
			return;
		}
		query.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String number = numberText.getText().toString();
				int num = Integer.valueOf(number);
				Log.d(TAG,"onclicked num:" + num);
				try {
					if ((resultView == null) || (bookQuery == null)) {
						if (resultView == null) {
							Log.d(TAG,"resultView == null ");
						} else {
							Log.d(TAG,"bookQuery == null ");
						}
						return ;
					}
					resultView.setText(bookQuery.queryBook(num));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		this.unbindService(bookConn);
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private final  class BookConnect implements ServiceConnection
	{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.d(TAG,"onServiceConnected");
			bookQuery = IBook.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d(TAG,"onServiceDisconnected");
			bookQuery = null;
			
		}
		
	}
}
