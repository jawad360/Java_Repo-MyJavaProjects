package input1;
import java.io.*;

public class Input1 {
	
	public static int input() throws IOException
	{
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(r);
		String s=new String();
		s=input.readLine();
		int a=Integer.parseInt(s);
		
		return(a);
	}
	

}
