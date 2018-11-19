import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AndoParse {

	/**
	 * @param args
	 */
	String[] titles;
	int[] postId;
	String[] fImg;
	String[] summary;
	String urlString ;
	String replace;
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no");
		int t = Integer.parseInt(br.readLine());
		
		AndoParse ap = new AndoParse();
		
		switch(t)
		{
			case 0: ap.urlString = "http://theandroidmagazine.com/feed/";	//no req
					ap.replace = "http://theandroidmagazine.com/?p=";
				break;
			case 1: ap.urlString = "http://www.androidcentral.com/feed/";		//desc no req
					ap.replace = " at http://www.androidcentral.com";
				break;
			case 2: ap.urlString = "http://feeds.feedburner.com/AndroidPolice";	//desc no req
					ap.replace = "http://www.androidpolice.com/?p=";
				break;
			case 3: ap.urlString = "http://phandroid.com/feed/";			//no req
					ap.replace = "http://phandroid.com/?p=";
				break;
			case 4: ap.urlString = "feed.androidauthority.com";
					ap.replace = "http://www.androidauthority.com/?p=";		//no protocol
				break;
			case 5: ap.urlString = "http://androidandme.com/feed/";			//no req
					ap.replace = "http://androidandme.com/?p=";
				break;
			case 6: ap.urlString = "http://www.androidguys.com/feed/";		//req needed
					ap.replace = "http://www.androidguys.com/?p=";
				break;
			case 7: ap.urlString = "http://androidspin.com/feed/";			//desc req needed
					ap.replace = "http://androidspin.com/?p=";
				break;
			case 8: ap.urlString = "http://www.androidheadlines.com/feed";	//req neded
					ap.replace = "http://www.androidheadlines.com/?p=";
				break;
		}
		
		ap.xmlParse();
		//ap.htmlParse();
		
	}
	private void htmlParse() 
	{
		org.jsoup.nodes.Document doc;
		try
		{
			doc =  Jsoup.connect("http://theandroidmagazine.com/").get();
			

			//Elements posts = doc.select("#content");
			org.jsoup.nodes.Element posts = doc.getElementById("content");
			
			for(int i=0; i<titles.length; i++)
			{
				org.jsoup.nodes.Element post = posts.child(i*2);
				int id = Integer.parseInt(post.attr("class").substring(5, 8));
				int pos = Arrays.binarySearch(postId, id);
				
				if(pos>-1)
					fImg[pos] = post.getElementsByTag("img").first().attr("src");
				System.out.println("Lang  "+post.attr("class") +" : "+fImg[i]+"\n"+posts.attr("class"));
			}
			
			
										
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		} 
	}
	private void xmlParse() throws Exception 
	{
		
		URL url = new URL(urlString);
		URLConnection urlCon = url.openConnection();
		
		urlCon.addRequestProperty("User-Agent", null);
		urlCon.addRequestProperty("Cookie", null);
		urlCon.connect();
		
		InputStream input = urlCon.getInputStream();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(input);
		
		NodeList nl = doc.getElementsByTagName("item");
		titles = new String[nl.getLength()];
		postId = new int[nl.getLength()];
		summary = new String[nl.getLength()];
		fImg = new String[nl.getLength()];
		
		for(int i=0; i<nl.getLength(); i++)
		{
			Node n = nl.item(i);
			Element ele = (Element)n;
			System.out.println("\n---------Item--------------");
			titles[i] = ele.getElementsByTagName("title").item(0).getTextContent();
			//postId[i] = ele.getElementsByTagName("guid").item(0).getTextContent();
			//postId[i] = postId[i].replace("http://theandroidmagazine.com/?p=", "");
			postId[i] = Integer.parseInt(ele.getElementsByTagName("guid").item(0).getTextContent().replace(replace, ""));
			String cData = ele.getElementsByTagName("content:encoded").item(0).getTextContent();
			hParse(cData,i);
			System.out.println(titles[i]+" : "+postId[i]+"\n");
			System.out.println(summary[i]+"\n"+fImg[i]);
		}
		
		System.out.println("-----------xml ends-----------");
	}
	void hParse(String data, int id)
	{
		org.jsoup.nodes.Document doc = Jsoup.parse(data);
		
		Elements hEle = doc.select("p");
		
		org.jsoup.nodes.Element eImg = doc.getElementsByTag("img").first();
		
		if(eImg!=null)
			fImg[id] = eImg.attr("src");
		summary[id] = "";
		for(org.jsoup.nodes.Element ele : hEle)
		{
			
			if(ele.text()!=null)
				summary[id] = summary[id]+ele.text();
		}
		
	}

}
