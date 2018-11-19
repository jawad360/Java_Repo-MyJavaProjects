package qbank;

public class IniUpper 
{
	 int x=9;
	

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}


	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IniUpper other = (IniUpper) obj;
		if (x != other.x)
			return false;
		return true;
	}


	public static void main(String args[])
	{
		String s = "all the best";
		
		char[] s1 = s.toCharArray();
		
		Character.toUpperCase(s1[0]);
		
		for(int i =0;i<s.length();i++)
			if(s1[i]==' ')
				Character.toUpperCase(s1[i]);
		
		System.out.println(s1.toString());
		
	}
}
