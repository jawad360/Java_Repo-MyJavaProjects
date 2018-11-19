package LineDrawing;

import java.awt.*;
import java.applet.*;

/*<applet code="LineDrawing.Dda.class" width=640 height=480>
</applet>*/

public class Line extends Applet
{

	public void init()
	{
		resize(640,480);
	}
	public void paint(Graphics g)

	{
		/*for (int i=10;i<=50 ;i++)
			g.drawRect(i, i, 1, 1);
		
		for (int i=20;i<=60 ;i++)
				g.drawLine(i+10, i, i+10, i);
		g.drawRect(10,10,1,1);*/
		
		for(int i =0;i<=640 ;i++)
			g.fillRect(i,0,1,1);		//proper choice
		
		for(int i =0;i<=640 ;i++)
			g.drawRect(i,4,1,1);
		
		//for(int i=0;i<=640;i++)
			//g.drawLine(i,2,i,2);
		//g.drawLine(0,0,640,480);
		
	}
}
