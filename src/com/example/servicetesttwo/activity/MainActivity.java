package com.example.servicetesttwo.activity;

import com.example.servicetesttwo.R;
import com.example.servicetesttwo.WelcomeActivity;
import com.example.servicetesttwo.R.layout;
import com.example.servicetesttwo.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String actionControl="com.example.servicetesttwo.service.doService";
	Button btnPlay,btnNext,btnGo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnPlay=(Button)this.findViewById(R.id.btnPlay);
		btnNext=(Button)this.findViewById(R.id.btnNext);
		btnGo=(Button)this.findViewById(R.id.btnGo);
		
		btnPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(actionControl);
				intent.putExtra("postMsg", "播放");
				startService(intent);
			}
		});	
        btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(actionControl);
				intent.putExtra("postMsg", "下一首");
				startService(intent);
			}
		});	
        btnGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this,LoginActivity.class );
				startActivity(intent);
			}
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
