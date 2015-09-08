package com.example.makemyradio;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shephertz.app42.paas.sdk.android.ServiceAPI;  
import com.shephertz.app42.paas.sdk.android.App42Response;  
import com.shephertz.app42.paas.sdk.android.App42Exception;  
import com.shephertz.app42.paas.sdk.android.App42BadParameterException;  
import com.shephertz.app42.paas.sdk.android.App42NotFoundException;  
import com.shephertz.app42.paas.sdk.android.user.User;  
import com.shephertz.app42.paas.sdk.android.user.UserService;  
import com.shephertz.app42.paas.sdk.android.user.UserService;

public class Login extends Activity implements OnClickListener
{
	Button bL; EditText etU,etP;TextView tvS;
	String status="";
	String sessionId;
	String userN;
	SharedPreferences saveData;
	public static String fileName="MyFile",enterText,printText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//ServiceAPI api = new ServiceAPI("56f8bd9368b0cba3be0a8b5c9f968267ba81fe9bdd24ccec5527ec4e3c977a00","e91e185bd76d38084bec2503f00c5232d891e562636100ab74db1c08b9c6796b"); 
		setContentView(R.layout.login);
		saveData=getSharedPreferences(fileName,0);
		intial();
		
	}
	private void intial() {
		// TODO Auto-generated method stub
		bL=(Button)findViewById(R.id.bLLogin);
		etU=(EditText)findViewById(R.id.etLUser);
		etP=(EditText)findViewById(R.id.etLPass);
		tvS=(TextView)findViewById(R.id.tvLStatus);
		bL.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		login();
		
	}
	private void login() {
		// TODO Auto-generated method stub
		userN=etU.getText().toString();
		String pass=etP.getText().toString();
		ServiceAPI api = new ServiceAPI("56f8bd9368b0cba3be0a8b5c9f968267ba81fe9bdd24ccec5527ec4e3c977a00","e91e185bd76d38084bec2503f00c5232d891e562636100ab74db1c08b9c6796b");
		UserService userService = api.buildUserService();
		userService.authenticate(userN, pass,new App42R(){
			@Override
			public void onException(Exception arg0) {
				System.out.println("error" + arg0.getMessage());
				//status=arg0.getMessage();
				//Toast.makeText(getBaseContext(),"Username or password invalid.", Toast.LENGTH_LONG).show();
			}

			@Override
			public void onSuccess(Object arg0) {
				SharedPreferences.Editor e=saveData.edit();
				e.putString("user", userN);
				e.commit();
				Intent flight=new Intent(Login.this,Radio.class);
				startActivity(flight);
				
			}
		}); 
		
	}
  
}
