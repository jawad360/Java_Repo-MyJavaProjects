package parsing;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test 
{
	public static void main(String args[]) throws IOException
	{
		
		new Test().run();	
	}

	private void run() throws IOException 
	{
		//Document doc = Jsoup.connect("http://www.google.co.in/images/srpr/logo11w.png").get();
		
		
		//Icon bank = new ImageIcon(getClass().getResource("http://www.google.co.in/images/srpr/logo11w.png"));
		
		//JOptionPane.showMessageDialog(null, null,"Welcome",JOptionPane.PLAIN_MESSAGE);
			
		JOptionPane.showMessageDialog(null, 
				"<html><body style=\"color:red\"><u>Welcome<u></body></html>",
				"jawad", JOptionPane.PLAIN_MESSAGE);
	}

}
