package test;


import java.sql.Driver;

public class TestCon 
{
	public static void main(String args[])
	{
		try
		{
			Driver d = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Works");
		}
		catch(Exception e)
		{
			System.out.println("fails..");
		}
	}
}
