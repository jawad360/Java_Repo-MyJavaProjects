package qbank;

import java.io.*;

public class Q1 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter string");
		String t;
		String[] s = new String[4];
		s[0]=input.readLine();
		s[1]=input.readLine();
		s[2]=input.readLine();
		s[3]=input.readLine();
		
		for(int i=0;i<4-1;i++)
			for(int j=0;j<4-1;j++)
				if(s[j].compareTo(s[j+1])>0)
				{
					t=s[j];
					s[j]=s[j+1];
					s[j+1]=t;
				}
		
		for(int i=0;i<4;i++)
			System.out.println(s[i]);
		
	}

}
