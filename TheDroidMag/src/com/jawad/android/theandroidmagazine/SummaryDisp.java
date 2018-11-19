package com.jawad.android.theandroidmagazine;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SummaryDisp extends Activity 
{
	TextView pubDate;
	TextView creator;
	TextView readMore;
	TextView title;
	ProgressBar sumPB;
	String[] sum ;
	Drawable d;
	Bitmap image;
	
	String guid;
	String url;
	WebView wb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary_disp);
		//sum = (Title)getIntent().getSerializableExtra("sum");
		//Gson gs =new Gson();
		//String t = getIntent().getStringExtra("sum");
		//Title sum = gs.fromJson(t, Title.class);
		wb = (WebView)findViewById(R.id.sumWeb);
		//wb.setBackground(wb.getRootView().getBackground());
		
		sumPB = (ProgressBar)findViewById(R.id.progressBar1);
		sum = getIntent().getExtras().getStringArray("sum");
		
		
		pubDate  = (TextView)findViewById(R.id.pubDate);
		pubDate.setText(sum[2]);
		
		creator  = (TextView)findViewById(R.id.creator);
		creator.setText(sum[3]);
		
		title  = (TextView)findViewById(R.id.title);
		title.setText(sum[5]);
		
		guid = sum[4];
		url = "http://www.readability.com/m?url="+guid;
		
		new MyAsy2().execute(url);
		
	}
	
	private class MyAsy2 extends AsyncTask<String,String,String>
	{
		
		protected String doInBackground(String... arg) 
		{
			
			
			try 
			{
				Document doc = Jsoup.connect(url).timeout(10000).get();
				
				Elements heading = doc.select("#rdb-article-content");
				
				wb.loadData("<html>" +"<head><meta charset=\"utf-8\"></head>"+
						"<body>"+doc.select("link")+""+heading+"</body></html>","text/html", "UTF-8");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			
			return null; 
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			sumPB.setVisibility(View.GONE);
			super.onPostExecute(result);
		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary_disp, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
