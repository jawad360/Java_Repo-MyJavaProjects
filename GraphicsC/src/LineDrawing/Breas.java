package LineDrawing;

import java.applet.Applet;
import java.awt.Graphics;

public class Breas extends Applet
{

	public void paint(Graphics g)
	{
		int x1=100,y1=110,x2=10,y2=50;
		int dx = x2-x1;
		int dy = y2-y1;
		int e =dy*2-dx;
		int ex=0;
	   
	    int s1= (x1<x2)?1:-1;
	    int s2= (y1<y2)?1:-1;
	    
		if(dy>dx)
		{
			int t=dx;
			dx=dy;
			dy=t;
			ex = 1;
			
		}
		else
			ex=0;
		int i=1,x=x1,y=y1;
		do
		{
			g.fillRect(320+x, 240-y, 1, 1);
			while(e>=0)
			{
				if(ex==1)
					x=x+s1;
				else
					y=y+s2;
				e=e-2*dx;
			}
			if(ex==1)
				y=y+s2;
			else
				x=x+s1;
			e=e+2*dy;
			i++;
		}
		while(i<=dx);
		
			
	}
	public void init()
	{
		resize(640,480);
	}
	
}

