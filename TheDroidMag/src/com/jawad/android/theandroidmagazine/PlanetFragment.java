package com.jawad.android.theandroidmagazine;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.bumptech.glide.Glide;
//import com.squareup.picasso.Picasso;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlanetFragment extends Fragment
{
	ProgressBar progressB;
    public static final String ARG_PLANET_NUMBER = "planet_number";
    int pos;
    TextView tv1;
    TableLayout scrollItem; 
    View item1;
	int c = 0;
	boolean flag = false;
	Handler handler;
	
	String title[];
	String summary[];
	String img[];
	String pubDate[];
	String creator[];
	String guid[];
	View rootView;
	
	OnClickListener l;
    public PlanetFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	rootView = inflater.inflate(R.layout.fragment_planet, container, false);
        
        pos = getArguments().getInt(ARG_PLANET_NUMBER);
        tv1 = (TextView)rootView.findViewById(R.id.textView1);
        String sites = getResources().getStringArray(R.array.planets_array)[pos];
        tv1.setText(sites);
        
        scrollItem = (TableLayout)rootView.findViewById(R.id.scrollItem);
        
        progressB = (ProgressBar)rootView.findViewById(R.id.pb99);
        
        title = new String[50];
        summary = new String[50];
        img = new String[50];
        pubDate = new String[50];
        creator = new String[50];
        guid = new String[50];
        
        
        
        try 
		{
        	 ConnectivityManager cm=(ConnectivityManager)getActivity().getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
             NetworkInfo info=cm.getActiveNetworkInfo();

             if(info == null)
             {
                 Toast.makeText(getActivity().getBaseContext(), "No internet connection", Toast.LENGTH_LONG).show();
             }
             else
             {
				 switch(pos)
				{
					case 0: flag = false;
					new MyAsy().execute("http://feeds.feedburner.com/AndroidPolice" ,"no","yes" );
						break;
					case 1: flag = false;
					new MyAsy().execute("https://www.androidpit.com/feed/main.xml" , "no","yes");
						break;
					case 2: flag = false;
					new MyAsy().execute("http://www.theandroidarcade.com/feed/","no","no" );
						break;
					case 3: flag = false;
					new MyAsy().execute("http://phandroid.com/feed/" , "no","no");
						break;
					case 4:flag = false;
					new MyAsy().execute("http://feed.androidauthority.com/" ,"no","no" );
						break;
					case 5:flag = false;
					new MyAsy().execute("http://feeds.feedburner.com/droidgamers?format=xml" ,"no","yes" );
						break;
					case 6:flag = false;
					new MyAsy().execute("http://www.androidguys.com/feed/" ,"yes","no" );
						break;
					case 7: flag = false;
					new MyAsy().execute("http://www.androidheadlines.com/feed" , "yes","no");
						break;
					case 8:flag = false;
					new MyAsy().execute("http://www.cultofandroid.com/feed/" ,"no","yes" );
						break;
					case 9:flag = false;
					new MyAsy().execute("http://feeds.feedburner.com/AndroidNewsGoogleAndroidForums?format=xml" ,"no","no" );
						break;
					case 10:flag = false;
					new MyAsy().execute("http://feeds.feedburner.com/androidosfeeds" ,"no","no" );
						break;
					case 11:flag = false;
					new MyAsy().execute("http://androidandme.com/feed/" ,"no","no" );
						break;
				}
             }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
        l = new OnClickListener()
        {

			@Override
			public void onClick(View arg0) 
			{
				int temp = arg0.getId();
				String t[] = new String[]{img[temp], summary[temp], pubDate[temp], creator[temp], guid[temp], title[temp]};
				
				Bundle ex = new Bundle();
				ex.putStringArray("sum", t);
				
				Intent i = new Intent(getActivity().getBaseContext(),SummaryDisp.class);
				i.putExtras(ex);
				startActivity(i);
			}
        	
        };
        
        return rootView;
    }
    private class MyAsy extends AsyncTask<String,String,String>
	{
    	String text;
    	String tag;
    	
    	String req;
    	String des;
    
    	Elements hEle;
    	org.jsoup.nodes.Document doc;
    	org.jsoup.nodes.Element eImg;
    	
    	URL urlConnection1;
    	HttpURLConnection connection1;
    	InputStream input1;
    	BitmapFactory.Options option;
    	
		protected String doInBackground(String... arg) 
		{
	    	req = arg[1];
	    	des = arg[2];
	    	InputStream input = null;
	    	URL url;
	    	URLConnection urlCon;
			try {
				url = new URL(arg[0]);
				urlCon = url.openConnection();
				HttpURLConnection httpCon = (HttpURLConnection)urlCon;			//this
				
				
				input = urlCon.getInputStream();
				
				if(req.equals("yes"))
				{
					urlCon.addRequestProperty("User-Agent", null);
					urlCon.addRequestProperty("Cookie", null);
					urlCon.connect();
				}
			
			} catch (Exception e) 
			{
				
			}
			catch(OutOfMemoryError e1)
			{
				System.gc();
			}
			XmlPullParserFactory factory = null;
			XmlPullParser parser = null;
			
			try
			{
				
				factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				parser = factory.newPullParser();
				parser.setInput(input,null);
				
				int type = parser.getEventType();
				
				while(type!=XmlPullParser.END_DOCUMENT)
				{
					tag = parser.getName();
					
					switch(type)
					{
					case XmlPullParser.START_TAG:	
													break;
					case XmlPullParser.TEXT: text = parser.getText();
													break;
													
					case XmlPullParser.END_TAG: check();
												
					}
					type = parser.next();
				}
				
			}
			catch(Exception e)
			{
				
			}
			catch(OutOfMemoryError e1)
			{
				System.gc();
			}
			return null;
	    }
	    void check() throws IOException
	    {
	    	if(tag.equals("title"))
	    		title[c] = text;
	    	else if(tag.equals("pubDate"))
	    		pubDate[c] = text.replace(" +0000", "");
	    	else if(tag.equals("creator"))
	    		creator[c] = text;
	    	else if(tag.equals("link"))		//change to guid
	    		guid[c] = text;
	    	else if(tag.equals("encoded"))
				htmlParse(text);
	    	else if(tag.equals("description") && des.equals("yes"))
				htmlParse(text);	
	    	else if(tag.equals("item"))
	    		set();

	    }
	    void htmlParse(String data)
		{
			doc = Jsoup.parse(data);
			
			hEle = doc.select("p");
			eImg = doc.getElementsByTag("img").first();
			
			if(eImg!=null)
				img[c] = eImg.attr("src");
			
			summary[c] = data;
			
				
		}
	    void set() throws IOException
	    {
	    	LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View item = inflater.inflate(R.layout.list_item,null);
			
			TextView tv = (TextView)item.findViewById(R.id.textView1);
			tv.setText(title[c]);
			
			item.setClickable(true);
			item.setId(c);
			
			TableLayout.LayoutParams  p = new TableLayout.LayoutParams ();
			p.setMargins(7, 5, 7, 5);
			item.setLayoutParams(p);
			while(flag)
			{
				
			}
			item1 = item;
			flag = true;
			getActivity().runOnUiThread(new Runnable() {
			    public void run() 
			    {
			    	item1.setOnClickListener(l);
					scrollItem.addView(item1);
					flag = false;
			    }
			});
			
			c++;
	    }
		
		@Override
		protected void onPostExecute(String result) 
		{
			progressB.setVisibility(View.GONE);
			
			
			for(int i=0; i<c; i++)
			{
				View t = rootView.findViewById(i);
				ImageView iv = (ImageView) t.findViewById(R.id.imageView1);

				Glide.with(getActivity().getBaseContext()) //
		                .load(img[i])
		                .placeholder(R.drawable.loading) //
		                .error(R.drawable.no_image) //
		                //.fit()
		                .centerCrop()
		                .into(iv);
			}
			super.onPostExecute(result);
		}
	    
	}
    
}
