package parsing;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MagParse {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String url = "http://www.readability.com/m?url=http://theandroidmagazine.com/xiaomi-i-is-coming-event-on-april-23rd-gets-global-coverage/";
		Document doc = Jsoup.connect(url).timeout(10000).get();
		
		//Elements heading = doc.select("#rdb-article-content");
		
		/*Elements links = doc.select("link");
		for(Element link : links)
			if(link.attr("rel").equals("stylesheet"))
				System.out.println("Style sheet\n"+link);
		*/
		//System.out.println("Heading\n"+heading);
		System.out.println("Style sheet\n"+doc.select("link"));
		
	}

}
