package parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AdvPar
{
	public static void main(String args[])
	{
		Document doc;
		try
		{
			doc = Jsoup.connect("http://en.wikipedia.org/wiki/Hacking").get();
			
			Element heading = doc.select("h1.firstheading").first();
			System.out.println(heading.text()+"\n");
			
			Elements langs = doc.select("#p-lang div.body ul li a");
			
			for(Element lang : langs)
			{
				System.out.println("Lang  "+lang.text());
			}
			
			
										
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
