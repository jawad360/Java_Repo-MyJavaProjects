package ieee;

import java.util.Scanner;

public class IEEE2Dec 
{
	StringBuffer sign = new StringBuffer("0");
	StringBuffer exp = new StringBuffer("10000100");
	StringBuffer signi = new StringBuffer("01111011000000000000000");
	
	StringBuffer decNo;
	StringBuffer expNo;
	int dec;
	double expo;
	int pow;
	
	public static void main(String args[])
	{
		IEEE2Dec i = new IEEE2Dec();
		i.start();
	}
	
	void start()
	{
		//accept();
		calDec();
		calExp();
		System.out.println("Ans "+dec+"  "+expo);
		
		System.out.println("Ans  :"+(dec+expo));
	}
	void accept()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter sign bit");
		sign = new StringBuffer(sc.next());
		System.out.println("Enter 8 bit exponent");
		exp = new StringBuffer(sc.next());
		System.out.println("Enter significant");
		signi = new StringBuffer(sc.next());
		
		System.out.println("Length "+exp.length()+" "+Character.getNumericValue(exp.toString().charAt(0)));
		
	}
	
	int dec(StringBuffer sb)
	{
		double sum=0;
		
		for(int i=0;i<sb.length();i++)
		{
			sum += Character.getNumericValue(sb.toString().charAt(i))*(Math.pow(2, (sb.length()-i-1)));
			
		}
		return (int)sum;
	}
	double dec1(StringBuffer sb)
	{
		double sum=0;
		
		for(int i=1;i<=sb.length();i++)
		{
			sum += Character.getNumericValue(sb.toString().charAt(i-1))*(Math.pow(2, -1*i));
			
		}
		return sum;
	}
	void calDec()
	{
		pow = dec(exp)-127;
		
		decNo = new StringBuffer("1"+signi.toString().substring(0, pow));
		
		dec = dec(decNo);
	}
	void calExp()
	{
		expNo = new StringBuffer(signi.toString().substring(pow));
		
		expo = dec1(expNo);
		
	}

}
