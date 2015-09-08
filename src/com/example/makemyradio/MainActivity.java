package com.example.makemyradio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.shephertz.app42.paas.sdk.android.ServiceAPI;  
import com.shephertz.app42.paas.sdk.android.App42Response;  
import com.shephertz.app42.paas.sdk.android.App42Exception;  
import com.shephertz.app42.paas.sdk.android.App42BadParameterException;  
import com.shephertz.app42.paas.sdk.android.App42NotFoundException;  
import com.shephertz.app42.paas.sdk.android.review.Review;  
import com.shephertz.app42.paas.sdk.android.review.ReviewService;  

public class MainActivity extends Activity implements OnClickListener {

	Toast t;
	WebView ourwv;
	RatingBar rb;
	String url;
	Button bC;
	EditText et;
	private ReviewService reviewService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gaana);
        Bundle suitcase=getIntent().getExtras();
		  url=suitcase.getString("key_data");
        ourwv=(WebView) findViewById(R.id.webView1);
        ourwv.loadUrl(url);
      //Brings keyboard in inner textbox of website
        ourwv.requestFocus(View.FOCUS_DOWN);
        ourwv.setWebViewClient(new myWebViewClient());
        ourwv.getSettings().setLoadWithOverviewMode(true);
        ourwv.getSettings().setJavaScriptEnabled(true);
        ourwv.getSettings().setUseWideViewPort(true);
        ourwv.getSettings().setBuiltInZoomControls(true);
        
        
       

   	 
      
        
        intialise();
        
      
      
        
    }

    private void intialise() 
    {
		// TODO Auto-generated method stub
		et=(EditText) findViewById(R.id.etGComments);
		bC=(Button) findViewById(R.id.bGaaana);
		
		
	}

	

	@Override
	public void onClick(View ar)
	{
		// TODO Auto-generated method stub
		
		ServiceAPI api = new ServiceAPI("56f8bd9368b0cba3be0a8b5c9f968267ba81fe9bdd24ccec5527ec4e3c977a00","e91e185bd76d38084bec2503f00c5232d891e562636100ab74db1c08b9c6796b");
				
		String userID = "Nick";  
		String itemID = "itemID";  
		String reviewComment = et.getText() .toString(); 
		double reviewRating = rb.getRating();                      
		reviewService.createReview(userID,itemID,reviewComment,reviewRating);    
		 
			 
			//hiding keyboard
			//InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			//imm.hideSoftInputFromWindow(url.getWindowToken(),0);
             
			
			
			
		}
		
	}
	


