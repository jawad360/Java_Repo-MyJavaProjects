package circledrawing;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ReflectionTest extends Applet 
{
	int xl1=0, yl1=20, xl2=60, yl2=50;
	double m= 0.5, c=20;
	
	int x1=20, y1=40, x2=40, y2=60;
	
	public void init()
	{
		resize(640,480);
	}
	public void paint(Graphics g)
	{
		g.drawLine(0,240,640,240);
		g.drawLine(320,0,320,480);
		double t = Math.asin(1);
		g.setColor(Color.RED);
		
		g.drawLine(320+xl1, 240-yl1, 320+xl2, 240-yl2);
		g.drawLine(320+x1, 240-y1, 320+x2, 240-y2);
		
		double d1 = cal(x1,y1);
		double d2 = cal(x2,y2);
		
		double x3,y3,x4,y4;
		x3 = 2*d1*Math.cos(Math.atan(-1/m))+x1;
		y3 = 2*d1*Math.sin(Math.atan(-1/m))+y1;
		
		x4 = 2*d2*Math.cos(Math.atan(-1/m))+x2;
		y4 = 2*d2*Math.sin(Math.atan(-1/m))+y2;
		
		g.setColor(Color.BLUE);
		g.drawLine(320+(int)x3, 240-(int)y3, 320+(int)x4, 240-(int)y4);
		
	}
	double cal(int x, int y)
	{
		double t;
		t = (m*x-y+c)/(Math.sqrt(m*m+1));
		
		if(t<0)
			t *= -1;
		
		return t;
	}

}
