package spcc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class loop_fusion
{
	public static void main(String arg[])throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("loop_fusion"));
		String s=new String();
		StringBuffer sb=new StringBuffer();
		System.out.println("INPUT:");
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
			sb.append(s+"\n");
		}

		int x=sb.indexOf("n",2);
		sb.replace(x,x+1,"n*m");
		int y=sb.indexOf("do");
		int z=sb.indexOf(";",9);
		sb.replace(y+2,z,"\na(i)=10");
		System.out.println("\n\n\nOUTPUT:");
		System.out.println(sb.toString());
	}
}
