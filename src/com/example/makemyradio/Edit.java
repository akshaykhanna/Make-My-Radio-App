package com.example.makemyradio;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Edit extends Activity implements OnClickListener
{
	Button bG,bU,bR,bP,bL;
	String s="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit2);
		intial();
	}

	private void intial() {
		// TODO Auto-generated method stub
		bG=(Button)findViewById(R.id.bEGana);
		bU=(Button)findViewById(R.id.bEU);
		bR=(Button)findViewById(R.id.bERecord);
		bP=(Button)findViewById(R.id.bEPlay);
		bL=(Button)findViewById(R.id.bMyLib);
		bG.setOnClickListener(this);
		bU.setOnClickListener(this);
		bR.setOnClickListener(this);
		bP.setOnClickListener(this);
		bL.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		Intent flight=new Intent(Edit.this,MainActivity.class);
		Bundle suitcase=new Bundle();
		switch(arg0.getId())
		{
		case R.id.bEGana:
			//Intent flight1=new Intent(Edit.this,MainActivity.class);
			//startActivity(flight1);
			 s="http://m.gaana.com/newreleases";
			
			suitcase.putString("key_data", s);
			
			flight.putExtras(suitcase);
			startActivity(flight);
			break;
		case R.id.bEU:
			
			s="http://m.gaana.com/singalong";
			
			suitcase.putString("key_data", s);
			
			flight.putExtras(suitcase);
			startActivity(flight);
			break;
		case R.id.bERecord:
			Intent flight2=new Intent(Edit.this,AudioRecordTest.class);
			
			
			startActivity(flight2);
			break;
		case R.id.bEPlay:
			Toast.makeText(getBaseContext(),"Currently don't have neccessary priviliges to publish.", Toast.LENGTH_LONG).show();
			break;
		case R.id.bMyLib:
			Intent flight5=new Intent(Edit.this,Mylib.class);
			startActivity(flight5);
			break;
		}
	}
}
