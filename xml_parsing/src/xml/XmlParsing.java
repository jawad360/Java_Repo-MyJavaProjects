package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing 
{
	public static void main(String args[]) throws Exception
	{
		File file = new File("tvshow.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(file);
		
		NodeList nl = dom.getElementsByTagName("show");
		
		Node node = nl.item(0);
		Element ele = (Element)node;
		
		System.out.println(dom.getDocumentElement().getNodeName());
		System.out.println(node.getNodeName());
		System.out.println(ele.getElementsByTagName("release").item(0).getTextContent());
		
		NodeList nl1 = dom.getElementsByTagName("actors");
		System.out.println(nl1.item(0).getNodeName());
	}

}
