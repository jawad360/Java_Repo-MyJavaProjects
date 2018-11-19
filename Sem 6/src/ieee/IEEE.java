package ieee;

import java.util.Scanner;

public class IEEE 
{
	double x = 309.1875,x2;
	int x1;
	
	StringBuffer x1Bin = new StringBuffer("");
	StringBuffer x2Bin = new StringBuffer("");
	
	String split1;
	String split2;
	
	StringBuffer exp = new StringBuffer("");
	StringBuffer signi = new StringBuffer("");
	
	
	public static void main(String[] args)
	{
		IEEE i = new IEEE();
		i.start();
	}
	void start()
	{
		accept();
		splitDecNo();
		x1Bin = bin(x1);
		split();
		calEx();
		calx2Bin();
		calSi();
		
		int t = x>=0? 0:1;
		System.out.println(t +"  "+exp+"  "+signi.toString());
	}
	void accept()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no");
		x = sc.nextDouble();
	}
	void splitDecNo()
	{
		x1 = (int)x;
		x2 = x-(int)x;
		System.out.println(x1+"  "+x2);
	}
	StringBuffer bin(int t)
	{
		StringBuffer temp = new StringBuffer();
		int t1;
		while(t!=0)
		{
			t1 = t%2;
			temp = temp.append(t1);
			t=t/2;
		}
		temp = temp.reverse();
		
		System.out.println(temp);
		return temp;
	}
	void split()
	{
		split1 = x1Bin.toString().substring(0, 1);
		split2 = x1Bin.toString().substring(1);
		
		System.out.println("Split1  "+split1+"\nsplit2  "+split2);
	}
	void calx2Bin()
	{
		int t=0;
		int i=0;
		
		while(x2!=0 && i<=23)
		{
			t = (int)(x2*2);
			x2 = (x2*2) - (int)(x2*2);
			x2Bin = x2Bin.append(t);
			i++;
		}
	}
	void calEx()
	{
		int temp = split2.length()+127;
		
		exp = bin(temp);
		
		System.out.println("exp "+exp);
	}
	void calSi()
	{
		String temp = split2+x2Bin.toString();
		signi = new StringBuffer(temp);
		System.out.println("signi "+signi);
	}
	

}
