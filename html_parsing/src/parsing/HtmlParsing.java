package parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParsing 
{
	public static void main(String args[])
	{
		Document doc;
		
		try
		{
			doc = Jsoup.connect("https://www.google.co.in/").get();
			
			System.out.println("Title\t"+doc.title());
			
			Elements urls = doc.select("a");
			
			for(Element url : urls)
			{
				System.out.println(url);
				System.out.println("--------------------------------");
				System.out.println("Attribute : "+url.attr("href")+"\nText : "+url.text());
				
			}
		}
		catch(Exception e)
		{
			
		}
		
	}

}
