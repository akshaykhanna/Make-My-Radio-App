package com.example.makemyradio;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class New extends Activity implements OnClickListener, OnItemSelectedListener
{
	Button b;
	Spinner sp1;
	String type[]={"News","Top 10","SUFI & Classical","Dveotional","Programmes","Band","Education","Regional"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lay_new);
		intial();
		
	}

	private void intial() {
		// TODO Auto-generated method stub
		b=(Button)findViewById(R.id.bNSubmit);
		sp1=(Spinner)findViewById(R.id.spNType);
		b.setOnClickListener(this);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(New.this,android.R.layout.simple_spinner_item,type);
		sp1.setAdapter(adapter);
		sp1.setOnItemSelectedListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
   Intent flight2=new Intent(New.this,Edit.class);
		startActivity(flight2);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
