import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ComluParse 
{
	public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException
	{
		String urlString = "http://theandroidmagazine.com/feed/";
		
		URL url = new URL(urlString);
		URLConnection urlCon = url.openConnection();
		InputStream input = urlCon.getInputStream();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(input);
		
		NodeList nl = doc.getElementsByTagName("item");
		Node n = nl.item(0);
		Element ele = (Element)n;
		
		System.out.println("Title : "+ele.getElementsByTagName("title").item(0).getTextContent());
		System.out.println("--------------------------");
		
		for(int i=0; i<nl.getLength(); i++)
		{
			Node n1 = nl.item(i);
			Element ele1 = (Element)n1;
			
			System.out.println("Title : "+ele1.getElementsByTagName("title").item(0).getTextContent());
			System.out.println("Description : "+ele1.getElementsByTagName("content:encoded").item(0).getTextContent());
			System.out.println();
			
			System.out.println("Formatted text-----------------------");
			String cData = ele1.getElementsByTagName("content:encoded").item(0).getTextContent();
			
			
			htmlParse(cData);
			System.out.println();
			System.out.println("---------------------------------------");
		}
		
		//htmlParse();
	}
	static void htmlParse(String data)
	{
		org.jsoup.nodes.Document doc = Jsoup.parse(data);
		
		Elements hEle = doc.select("p");
		
		
		for(org.jsoup.nodes.Element ele : hEle)
		{
			System.out.println("Para : "+ele.text());
			System.out.println();
		}
		
		
	}

}
