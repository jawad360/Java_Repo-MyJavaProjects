import java.lang.reflect.Array;
import java.util.Arrays;


public class BTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(Booth.dec(new int[]{1,1,1,1}));	//dec() working
		
		int[] x = new int[4];
		x = Booth.bin(4);
		
		for(int i=0;i<4;i++)
			System.out.print(x[i]);				//bin working
		System.out.println();
		
		x = Booth.cal(new int[]{1,1,0,1}, new int[]{0,0,0,1}, '+');
		
		for(int i=0;i<4;i++)
			System.out.print(x[i]);		//add working
		System.out.println();
		
		x = Booth.cal(new int[]{1,1,1,1}, new int[]{0,0,1,1}, '-');
		
		for(int i=0;i<4;i++)
			System.out.print(x[i]);		//sub working
		
		System.out.println("\n"+Arrays.toString(sub(new int[]{0,1,1,0},new int[]{0,1,1,1})));
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
		
		if(ans > 15)
			return Booth.bin(ans);
		
		else
		{
			int[] x1 = new int[4];
			x1 = Booth.bin(ans);
			
			for(int i=0;i<4;i++)
			{
				if(x1[i]==0)
					x1[i] = 1;
				else
					x1[i] = 0;
			}
			return Booth.cal(x1, new int[]{0, 0,0,1},'+');
			
		}
			
	}

}
