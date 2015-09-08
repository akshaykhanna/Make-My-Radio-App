package com.example.makemyradio;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LR  extends Activity implements OnClickListener{
     
	Button bR,bL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blr);
		intialise();
		}

	private void intialise() {
		// TODO Auto-generated method stub
		bL=(Button)findViewById(R.id.bLogin);
		bR=(Button)findViewById(R.id.bRegister);
		bL.setOnClickListener(this);
		bR.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bLogin:
			Intent flight=new Intent(LR.this,Login.class);
			startActivity(flight);
			break;
		case R.id.bRegister:
			Intent flight1=new Intent(LR.this,Register.class);
			startActivity(flight1);
			break;
	  }
	}

}
