package advjava;


import java.util.*;

public class HashTest 
{
	public static void main(String args[])
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(11);
		hs.add(28);
		hs.add(3);
		int t = 0;
		for(Integer i : hs)
		{
			System.out.println(i);
			t += i;
		}
		System.out.println("Total "+t);
	}

}
