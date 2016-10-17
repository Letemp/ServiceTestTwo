package com.example.servicetesttwo.activity;

import com.example.servicetesttwo.R;
import com.example.servicetesttwo.WelcomeActivity;
import com.example.servicetesttwo.R.layout;
import com.example.servicetesttwo.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private static final String actionTransferUpdate="com.example.servicetesttwo.service.transferUpdate";
	Button btnBack;
	TextView tvShowMsg;
	LoginActivityReceiver lar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		btnBack=(Button)this.findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(LoginActivity.this,MainActivity.class );
				startActivity(intent);
			}
		});
		tvShowMsg=(Button)this.findViewById(R.id.tvShowMsg);
		
		lar=new LoginActivityReceiver();
		IntentFilter ifSetAction=new IntentFilter();
		ifSetAction.addAction(actionTransferUpdate);
		registerReceiver(lar,ifSetAction);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	public class LoginActivityReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			tvShowMsg.setText(intent.getStringExtra("postMsg"));
		}
		
	}

}
