package com.example.makemyradio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shephertz.app42.paas.sdk.android.ServiceAPI; 
import com.shephertz.app42.paas.sdk.android.user.User; 
import com.shephertz.app42.paas.sdk.android.user.UserService;

public class Register extends Activity implements OnClickListener
{
    Button bR; EditText etU,etE,etP,etCp;TextView tvS;
    String status="";
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		intialise();
		
	}
	
	
	private void register() {
		// TODO Auto-generated method stub
		status="";
		String userName = etU.getText().toString(); 
		String p = etP.getText().toString();
		String cp = etCp.getText().toString();
		//tvS.setText(p+"  "+cp);
		if(p.equalsIgnoreCase(cp))
		{
		String emailId = etE.getText().toString();
		ServiceAPI api = new ServiceAPI("56f8bd9368b0cba3be0a8b5c9f968267ba81fe9bdd24ccec5527ec4e3c977a00","e91e185bd76d38084bec2503f00c5232d891e562636100ab74db1c08b9c6796b");
		UserService userService = api.buildUserService(); 
		userService.createUser(userName, p, emailId,new App42R(){
			@Override
			public void onException(Exception arg0) {
				System.out.println("error" + arg0.getMessage());
				
			}

			@Override
			public void onSuccess(Object arg0) {
				Intent flight=new Intent(Register.this,Login.class);
				startActivity(flight);
			}
		}); 
			
		}
		else
		{
		status+="Password and conifrm Password does not match. ";	
		}
		tvS.setText(status);
	}
	private void intialise() {
		// TODO Auto-generated method stub
		bR=(Button)findViewById(R.id.bSubmit);
		etU=(EditText)findViewById(R.id.etUsername);
		etE=(EditText)findViewById(R.id.etEmail);
		etP=(EditText)findViewById(R.id.etPass);
		etCp=(EditText)findViewById(R.id.etCpass);
		tvS=(TextView)findViewById(R.id.tvRStatus);
		bR.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		register();
		if(status=="")
		{
			Intent flight=new Intent(Register.this,Login.class);
			startActivity(flight);
		}
	}
  
}
