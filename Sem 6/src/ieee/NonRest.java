package ieee;

import java.util.*;
public class NonRest 
{
	int q1,m1;
	int[] q = new int[4];
	int[] m = new int[4];
	int[] mc = new int[4];
	int[] a = new int[]{0,0,0,0};

	
	public static void main(String[] args)
	{
		NonRest n = new NonRest();
		n.start();
	}
	void start()
	{

		accept();
		q = bin(q1);
		m = bin(m1);
		mc = bin(m1);
		mc = compl(mc);
		
		compute();
		System.out.println("Quo:  "+dec(q)+"\nRem:  "+dec(a));
	}
	void accept()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter q/m");
		q1 = sc.nextInt();
		m1 = sc.nextInt();
		sc.close();
	}
	int[] bin(int x)
	{
		int[] t = new int[4];
		int y;
		for(int i=0,j=3;i<4;i++,j--)
		{
			y=x%2;
			t[j] = y;
			x=x/2;
		}
		return t;
	}
	int[] compl(int[] x)
	{
		for(int i=0;i<4;i++)
		{
			if(x[i]==0)
				x[i]=1;
			else
				x[i]=0;	
		}
		x = add(x,new int[]{0,0,0,1});
		return x;
	}
	void compute()
	{
		for(int i=0;i<4;i++)
		{
			if(a[0]==0)
			{
				shift();
				a = add(a,mc);
				
			}
			else
			{
				shift();
				a = add(a,m);
			}
			q[3] = a[0]==0?1:0;
		}
		if(a[0]==1)
		{
			a = add(a,m);
		}
	}
	void shift()
	{
		for(int i=0;i<4-1;i++)
			a[i]=a[i+1];
		a[3]=q[0];
		for(int i=0;i<4-1;i++)
			q[i]=q[i+1];
	}
	int[] add(int[] x,int[] y)
	{
		int[] ans = new int[4];
		
		int x1,y1,ans1;
		
		x1 = dec(x);
		y1 = dec(y);
		ans1 = x1+y1;
		
		ans = bin(ans1);
		return ans;
	}
	int dec(int[] x)
	{
		int a = 0;
		for(int i=0,j=3;j>=0;j--,i++)
		{
			a += x[i]*(int)Math.pow(2, j);
		}
		return a;
	}
 
}