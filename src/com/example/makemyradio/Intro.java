package com.example.makemyradio;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;


public class Intro extends Activity 
{

	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	
		setContentView(R.layout.start);//Setting starting layout 
		
		
		
		
		
		
		
		Thread timer= new Thread()
		{

			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				
				try
				{
					sleep(1000);//layout will be displayed for 3sec
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
					
				}
				finally
				{
					Intent sta2= new Intent("com.example.makemyradio.LR");//Finally it will start menu activity
					startActivity(sta2);
					
				}
			
				
				
			}
		
		};
		timer.start();
		
		
		
		
		
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		
		
	}
	
	

}
