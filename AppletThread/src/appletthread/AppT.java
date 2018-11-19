package appletthread;


import java.applet.*;
import java.awt.*;

public class AppT extends Applet
{
	
	public void init()
	{
		Graphics g = null;
		g.drawString("Initailising", 10, 10);
		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		g.drawString("Painting", 20, 20);
		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		repaint();

		g.drawString("Painting", 20, 20);

		repaint();

	}
}
