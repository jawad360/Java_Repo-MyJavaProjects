package upper;

public class IniUpper 
{

	public static void main(String args[])
	{
		String s = "all the yu to best";
		
		System.out.println(s);

		
		char s1[] = s.toCharArray();
		
		s1[0]=Character.toUpperCase(s1[0]);
		
		for(int i =0;i<s.length();i++)
			if(s1[i]==' ')
			{
				i++;
				s1[i]=Character.toUpperCase(s1[i]);
			}
		String x = new String(s1);
		System.out.println(x);
		
	}
}
