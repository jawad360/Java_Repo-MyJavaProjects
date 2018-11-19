package circledrawing;

import java.applet.Applet;
import java.awt.Graphics;

public class Circle extends Applet
{
	public void paint(Graphics g)
	{
		int x,y,r=80;
		double t;
		x=0;
		y=r;
		
		do
		{
			plot(x,y,g);
			x++;
			t = Math.sqrt(r*r - x*x);
			
			if((t - (int)t)<0.5)
				y = (int)t;
			else
				y = (int)t+1;
		}while(x<=y);
		
	}
	public void plot(int x,int y,Graphics g)
	{
		g.fillRect(200+x,200+y,1, 1);
		g.fillRect(200+y,200+x,1, 1);
		g.fillRect(200-x,200-y,1, 1);
		g.fillRect(200-y,200-x,1, 1);
		g.fillRect(200+x,200-y,1, 1);
		g.fillRect(200-y,200+x,1, 1);
		g.fillRect(200-x,200+y,1, 1);
		g.fillRect(200+y,200-x,1, 1);

	}

}
