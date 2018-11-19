

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
			doc = Jsoup.connect("http://www.readability.com/m?url=http://theandroidmagazine.com/?p=1471").timeout(10000).get();
			
			Elements heading = doc.select("#rdb-article-content");
			System.out.println(heading+"\n");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
