
public class CharFreq 
{
	public static void main(String args[])
	{
		String s="jawadsonalkar";
		
		char a[] = s.toCharArray();
		
		for(int i=0;i<a.length-1;i++)
			for(int j=0;j<a.length-1;j++)
			{
				if(a[j]>a[i])
				{
					char t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		
		String s1 = new String(a);
		
		System.out.println(s1);
		
		int c=1;

		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]==a[i+1])
				c++;
			else
			{
				System.out.println((char)a[i]+"==>"+c);
				c=1;

			}
		}
		
	}

}
