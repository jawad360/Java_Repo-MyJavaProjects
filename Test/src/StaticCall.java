
public class StaticCall 
{

	public static void display()
	{
		System.out.println("Displaying.....");
		StaticCall s = new StaticCall();
		s.show();
	}
	void show()
	{
		this.show1();
	}
	void show1()
	{
		System.out.println("Show 1");
	}
	public static void main(String[] args) 
	{
		display();
		StaticCall c = new StaticCall();
		c.display();
		//StaticCall.main(args);
	}
	

}
