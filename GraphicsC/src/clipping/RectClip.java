package clipping;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class RectClip extends Applet
{
	int xmin=0, ymin=0, xmax=100, ymax=100;
	int x1=-40,y1=-20,x2=170,y2=120;
	
	public void init()
	{
		resize(640,480);
	}
	public void paint(Graphics g)
	{
		int tx1 = 0,ty1=0,tx2=0,ty2=0,tc=0;
		double x=0, y=0;
		int dy = y2-y1, dx = x2-x1;
		
		g.drawLine(0, 240, 640, 240);
		g.drawLine(320, 0, 320, 480);
		
		g.setColor(Color.RED);
		g.drawRect(320, 240-ymax, xmax, ymax);
		g.drawLine(320+x1,240-y1, 320+x2, 240-y2);
		
		g.setColor(Color.BLUE);
		
		if(dx==0 && x1<=xmax && x1>=xmin)
		{
			if(y1<=ymin && y2>=ymax)
				g.drawLine(320+x1, 240-ymin, 320+x2, 240-ymax);
			if(y1<=ymin && y2<=ymax)
				g.drawLine(320+x1, 240-ymin, 320+x2, 240-y2);
			if(y1>=ymin && y2>=ymax)
				g.drawLine(320+x1, 240-y1, 320+x2, 240-ymax);
			if(y1>=ymin && y2<=ymax)
				g.drawLine(320+x1, 240-y1, 320+x2, 240-y2);
				
		}
		else if(dy==0 && y1<=ymax && y1>=ymin)
		{
			if(x1<=xmin && x2>=xmax)
				g.drawLine(320+xmin, 240-y1, 320+xmax, 240-y2);
			if(x1<=xmin && x2<=xmax)
				g.drawLine(320+xmin, 240-y1, 320+x2, 240-y2);
			if(x1>=xmin && x2>=xmax)
				g.drawLine(320+x1, 240-y1, 320+xmax, 240-y2);
			if(x1>=xmin && x2<=xmax)
				g.drawLine(320+x1, 240-y1, 320+x2, 240-y2);
				
		}
		else
		{
			//y = y1 + (dy/(double)dx)*(x-x1);
			//x = x1 + (dx/(double)dy)*(y-y1);
			
			if(x1>=xmin && y1>=ymin && x2<=xmax && y2<ymax)
				g.drawLine(320+x1, 240-y1, 320+x2, 240-y2);
			else
			{
				y=ymin;
				x = x1 + (dx/(double)dy)*(y-y1);
				if(x>=xmin && x<=xmax)
				{
					ty1=0;
					tx1=(int) x+1;
				}
				x=xmax;
				y = y1 + (dy/(double)dx)*(x-x1);
				if(y>=ymin && y<=ymax )
				{
					tx2 = xmax;
					ty2 = (int) y;
				}
				g.drawLine(320+tx1, 240-ty1, 320+tx2, 240-ty2);
			}
			
		}
		
	}	
}
