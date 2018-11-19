import java.util.Scanner;
import Rec.*;
class cir
{
	static int r ;
	static float x ;

	public static void accept()
	{
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
	}
	
	public static void cal()
	{
		x = (float)(3.14*r) ;	
	}
	
	public static void display()
	{
		System.out.println("Ans="+x);
		Rec r=new Rec();
		r.rec();
		
	}
}

class jd
{
	public static void main(String arg[])
	{
		System.out.println("Enter radius");
		
		cir.accept();
		cir.cal();
        cir.display();	
	}
}