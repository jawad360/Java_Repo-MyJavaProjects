

import java.util.Scanner;

class rect
{
	static int len;
	static int bred;
	static int area;
	
	public static void main(String args[])
	{
		rect r=new rect();
		r.accept();
		r.cal();
		r.display();
	}
	
	void accept()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter");
		len = s.nextInt();
		bred = s.nextInt();
	}
	
	static int cal()
	{
		area = len*bred;
		return(area);
	}
    
	void display()
	{
		System.out.println("Area="+area);
	}
}

class jd
{
    static int x ;
	public static void xy()
	{
		x = rect.cal();
		System.out.print(x);
	}
	
}