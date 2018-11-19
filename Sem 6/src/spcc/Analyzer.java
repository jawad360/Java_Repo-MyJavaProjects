package spcc;

import java.io.*;

class Analyzer
{
	public static void main(String arg[])throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("D:\\eclipse-java-juno-SR1-win32\\Myjavaprojects\\COA\\reduction"));
		String s=new String();
		StringBuffer sb=new StringBuffer();
		System.out.println("INPUT:");
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
			sb.append(s+"\n");
		}

		System.out.println("Output:");
		System.out.println("temp=7;");

		StringBuffer rd=new StringBuffer();

		int x=sb.indexOf("{");
		int y=sb.indexOf("}");
		sb.replace(x+1,y-1,"count=temp; \n temp=temp+7;\n");

		System.out.println(sb.toString());
	}
}
