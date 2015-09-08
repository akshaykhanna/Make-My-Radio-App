package com.example.makemyradio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Radio extends Activity implements OnClickListener {
	
	TextView tv;
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

	Button bB,bL;
	int c=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		intialise();
		
	}

	private void intialise() {
		// TODO Auto-generated method stub
		tv=(TextView)findViewById(R.id.tvChal);
		bB=(Button)findViewById(R.id.bBroad);
		bL=(Button)findViewById(R.id.bListen);
		bB.setOnClickListener(this);
		bL.setOnClickListener(this);
		
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bBroad:
			if(c==0)
			{
				c++;
				changeButton();
			}
			else
			{
				Intent flight1=new Intent(Radio.this,New.class);
				startActivity(flight1);
			}
		    
			break;
		case R.id.bListen:
			if(c==0)
			{
				//tv.setText("Listen Challa");
				Intent flight=new Intent(Radio.this,Listen.class);
				startActivity(flight);
			}
			else
			{
				Intent flight2=new Intent(Radio.this,Edit.class);
				startActivity(flight2);
			}
			break;
			
		}
	}

	private void changeButton() {
		// TODO Auto-generated method stub
		if(c>0)
		{
			bB.setText("Create new");
			bL.setText("Edit previous");
		}
	}

}
