package ieee;


import java.util.*;
public class NonRestoring 
{
	int q1,m1,n;
	int[] q;
	int[] m;
	int[] mc;
	int[] a;
	
	public static void main(String[] args)
	{
		NonRestoring n = new NonRestoring();
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
		
		int max = q1>m1?q1:m1;
		
		for(n=0; max>=Math.pow(2, n); n++);
		
		q = new int[n];
		m = new int[n];
		mc = new int[n];
		a = new int[n];
		
		sc.close();
	}
	int[] bin(int x)
	{
		int[] t = new int[n];
		int y;
		for(int i=0,j=n-1; i<n ;i++,j--)
		{
			y=x%2;
			t[j] = y;
			x=x/2;
		}
		return t;
	}
	int[] compl(int[] x)
	{
		int[] t = new int[n];
		t[n-1]=1;
		
		for(int i=0;i<n;i++)
		{
			if(x[i]==0)
				x[i]=1;
			else
				x[i]=0;	
		}
		x = add(x,t);//
		return x;
	}
	void compute()
	{
		for(int i=0;i<n;i++)
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
			q[n-1] = a[0]==0?1:0;
		}
		if(a[0]==1)
		{
			a = add(a,m);
		}
	}
	void shift()
	{
		for(int i=0;i<n-1;i++)
			a[i]=a[i+1];
		
		a[n-1]=q[0];
		
		for(int i=0;i<n-1;i++)
			q[i]=q[i+1];
	}
	int[] add(int[] x,int[] y)
	{
		int[] ans = new int[n];
		
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
		for(int i=0,j=n-1;j>=0;j--,i++)
		{
			a += x[i]*(int)Math.pow(2, j);
		}
		return a;
	}
 
}