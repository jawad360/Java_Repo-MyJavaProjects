package circledrawing;

import java.applet.Applet;
import java.awt.Graphics;

public class Ellipse extends Applet
{
	
	public void paint(Graphics g)
	{
		int x,y ,a=140,b=70;
		double t;
		
		x=0;
		y=b;
		do
		{
			plot(x,y,g);
			x++;
			t = Math.sqrt((1-(x*x)/(double)(a*a))*b*b);
			
			if((t - (int)t)<0.5)
				y = (int)t;
			else
				y = (int)t+1;
		}
		while(b*b*x<=a*a*y);  	//tangent i.e derivate <=1
		
		do
		{
			plot(x,y,g);
			y--;
			t = Math.sqrt((1-(y*y)/(double)(b*b))*a*a);
			
			if((t - (int)t)<0.5)
				x = (int)t;
			else
				x = (int)t+1;
		}
		while(y>=0);
		
		g.drawOval(200, 200, 70, 140);
		g.drawLine(200, 200, 300, 300);
	}

	public void plot(int x, int y, Graphics g) 
	{
		g.fillRect(200+x, 200+y, 1, 1);
		g.fillRect(200-x, 200+y, 1, 1);
		g.fillRect(200+x, 200-y, 1, 1);
		g.fillRect(200-x, 200-y, 1, 1);

	}

}
