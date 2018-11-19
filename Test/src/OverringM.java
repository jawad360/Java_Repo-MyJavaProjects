import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OverringM 
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		//Ani a = new Ani();
		Ani b = new Horse();
		//a.eat();
		b.eat();
	}

}
class Ani
{
	Ani()
	{
		System.out.println("Class Ani");
	}
	 public void eat() throws IOException
	{
		System.out.println("method eat of Ani");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
	}
}
class Horse extends Ani
{
	Horse()
	{
		System.out.println("Class Horse");
	}
	public  void eat()
	{
		System.out.println("method eat of Horse");
	}
}
