package circledrawing;

import java.applet.Applet;
import java.awt.Graphics;

public class Ell extends Applet
{
	public void init()
	{
		resize(640,320);
	}
	public void paint(Graphics g)
	{
		int rx=100, ry=60, x=0, y=ry;
		
		double p = ry*ry + rx*rx*(-ry + 0.25);
		
		while(2*x*ry*ry <= 2*y*rx*rx)
		{
			new Ellipse().plot(x, y, g);
			
			if(p<0)
			{
				x++;
				y=y;
				p += 2*(x+1)*ry*ry+ry*ry;
			}
			else
			{
				x++;
				y--;
				p += 2*(x+1)*ry*ry+ry*ry-2*(y-0.5)*rx*rx + rx*rx;
			}
		}
		System.out.println("Second region");
		g.drawLine(200,200,300,300);
		double p1 = (x+0.5)*(x+0.5)*ry*ry + (y-1)*(y-1)*rx*rx - rx*rx*ry*ry;
		
		while(y>=0)
		{
			new Ellipse().plot(x, y, g);
			
			if(p1<0)
			{
				x=x;
				y--;
				p1 -= 2*(y-1)*rx*rx+rx*rx;
			}
			else
			{
				x++;
				y--;
				p1 += 2*(x+0.5)*ry*ry+ry*ry-(y-1)*2*rx*rx+rx*rx;
			}
		}
		
		g.drawLine(200,200,300,300);
	}

}
