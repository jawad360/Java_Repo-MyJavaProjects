package nestclass_coll;

public class StaticClass 
{
	public static void main(String[] args) 
	{
		Outer.display();
		Outer x = new Outer();
		x.disp();
	}

}

class Outer
{
	static class Nest
	{
		void show()
		{
			System.out.println("Method show inside nest");
		}
	}
	static void display()
	{
		Nest n = new Nest();
		n.show();
	}
	void disp()
	{
		Outer.Nest o = new Outer.Nest();
		o.show();
	}
}