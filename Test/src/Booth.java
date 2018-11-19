import java.lang.reflect.Array;
import java.util.Arrays;


public class Booth
{

	public static void main(String[] args) 
	{
		int[] a = {0,0,0,0};
		int[] q = new int[4];
		int[] m = new int[4];
		int q1 = 0;
		
		int x=3, y =4;
		q = bin(y);
		m = bin(x);
		
		System.out.println("A\t\tQ\t\tQ1\t\tM");
		System.out.println(Arrays.toString(a)+"\t"+Arrays.toString(q)+" \t"+q1+"\t"+Arrays.toString(m));
	
		
		for(int i=0;i<4;i++)
		{
			if(q[3]==0 && q1==1)
				a = cal(a,m,'+');
			
			if(q[3]==1 && q1==0)
			{
			//	a = cal(a,m,'-');
				a = sub(a,m);
			}
			
			q1 = q[3];
			for(int k=3;k>0;k--)
			{
				q[k] = q[k-1];
			}
			q[0] = a[3];
			
			for(int k=3;k>0;k--)
				a[k] = a[k-1];
			
			System.out.println(Arrays.toString(a)+"\t"+Arrays.toString(q)+" \t"+q1+"\t"+Arrays.toString(m));
		
		}
		
		int ans=0;
		for(int i=3,j=0;i>=0;i--,j++)
			ans += q[i]*Math.pow(2, j);
		
		for(int i=3,j=4;i>=0;i--,j++)
			ans += a[i]*Math.pow(2, j);
		
		System.out.println(ans);
		
		
	}
	static int[] bin(int x)
	{
		int[] t = new int[4];
		for(int i=3;i>=0;i--)
		{
			t[i] = x%2;
			x = x/2;
		}
		return t;
	}
	static int dec(int[] x)
	{
		int t=0;
		for(int i=3,j=0;i>=0;i--,j++)
		{
			t += x[i]*(int)Math.pow(2,j);
		}
		return t;
	}
	static int[] cal(int[] a, int[] m, char s)
	{
		int x,y;
		x = dec(a);
		y = dec(m);
		
		int ans=0;
		if(s=='+')
			ans = x+y;
		if(s=='-')
			ans = x-y;
		return bin(ans);
	}
	public static int[] sub(int[] a, int[] m) 
	{
		int[] m1 = new int[4];
		System.arraycopy(m, 0, m1, 0, m.length);
		
		for(int i =0;i<4;i++)
		{
			if(m1[i]==0)
				m1[i]=1;
			else
				m1[i]=0;
		}
			
		m1 = Booth.cal(m1,new int[]{0,0,0,1},'+');
		
		int x,y;
		x = Booth.dec(a);
		y = Booth.dec(m1);
		int ans = x+y;
		
		return Booth.bin(ans);
	}

}
