package LineDrawing;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Bresenham extends Applet 
{

	public void paint(Graphics g)
	{
				
		int x1=0,y1=0,x2=20,y2=750;
		double m = (y2-y1)/(double)(x2-x1);
		double c = y1 - m*x1;
		
		int  x=x1, y=y1;
		if(m<=1 && m>=-1)
		{
			
			do
			{
				g.fillRect(320+x, 240-y, 1, 1);
				if(x1<x2)
					x++;
				else
					x--;
				
				double t = (m*x + c);
				if(t-(int)t>0.5)
					y= (int)t+1;
				else
					y = (int)t;
					
			}
			while(x!=x2);
		}
		else
		{
			do
			{
				g.fillRect(320+x, 240-y, 1, 1);
				if(y1<y2)
					y++;
				else
					y--;
				double t =((y-c)/m);
				if(t-(int)t > 0.5)
					x = (int)t+1;
				else
					x = (int)t;
				
			}
			while(y!=y2);
		}
		g.setColor(Color.BLUE);
		g.drawLine(0, 240, 640, 240);
		g.drawLine(320, 0, 320, 480);

	}
	public void init()
	{
		
		resize(640,480);
	}
	

}
