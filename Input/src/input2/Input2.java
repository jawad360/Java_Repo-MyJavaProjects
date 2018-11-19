package input2;

import java.io.IOException;
import input1.*;

public class Input2 {
	
	public static void main(String args[]) throws IOException
	{
		System.out.println("Enter");
		Input1 ip = new Input1();
		int a=ip.input();
		System.out.println("imported="+a);
		
	}

}
