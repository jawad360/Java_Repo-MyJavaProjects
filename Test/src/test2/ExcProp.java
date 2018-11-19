package test2;

import java.io.IOException;

public class ExcProp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		dostuff();
	}
	static void dostuff()throws IOException
	{
		domore();
	}
	static void domore()throws IOException
	{
		try {
			throw new IO();
		} catch (IO e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
class IO extends Exception
{}
