import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class MyPullParser 
{
	String urlAdd = "http://feeds.feedburner.com/droidgamers?format=xml";
	String text;
	public static void main(String[] args) throws IOException 
	{
		MyPullParser mpp = new MyPullParser();
		mpp.pullParse();
	}
	void pullParse() throws IOException
	{
		URL url = new URL(urlAdd);
		URLConnection urlCon = url.openConnection();
		InputStream input = urlCon.getInputStream();
		
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
				String tag = parser.getName();
				
				switch(type)
				{
				case XmlPullParser.START_TAG:	
												break;
				case XmlPullParser.TEXT: text = parser.getText();
												break;
												
				case XmlPullParser.END_TAG: 
											if(tag.equals("title"))
												System.out.println("-------Item-----------\n"+text);
											if(tag.equals("description"))
											{
												System.out.println("-------cOntent-----------\n"+text);
												System.out.println("-------Formatted-----------\n");
												new ComluParse().htmlParse(text);
											}
				
				
				}
				type = parser.next();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
