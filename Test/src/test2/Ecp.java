package test2;

public class Ecp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) //throws Exception 
	{
		stuff();
	}
	static void stuff() //throws Exception
	{
		try
		{
			throw new Exception();
		}
		catch(Exception e)
		{
			//throw e;
		}
	}

}
