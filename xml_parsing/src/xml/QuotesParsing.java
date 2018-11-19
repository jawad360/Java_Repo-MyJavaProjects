package xml;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QuotesParsing 
{
	public static void main(String args[])throws Exception
	{
		File file = new File("quotes.xml");
		
		String yql = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%20in%20(%22"
				     +"msft"
				     +"%22)&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		
		URL url = new URL(yql);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(in);
		
		NodeList nl = doc.getElementsByTagName("quote");
		
		
		Node nl1 = nl.item(0);
		Element ele = (Element)nl1;
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		if(nl!=null && nl.getLength()>0)
		{
			System.out.println(ele.getElementsByTagName("Name").item(0).getTextContent());
			System.out.println(ele.getElementsByTagName("DaysLow").item(0).getTextContent());
			System.out.println(ele.getElementsByTagName("DaysHigh").item(0).getTextContent());
			System.out.println(ele.getElementsByTagName("Change").item(0).getTextContent());
		}
		
	}

}
