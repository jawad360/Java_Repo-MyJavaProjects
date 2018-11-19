
public class DMD 
{
	public static void main(String []args)
	{

		Aa a = new Bb();
		a.display();
		a.show();
		
		Bb b = new Bb();
	}

}

class Aa
{
	void display()
	{
		System.out.println("Class Aa");
		
	}

	  void show() {
		
	}
	  
}
class Bb extends Aa
{
	void display()
	{
		System.out.println("Class Bb");
		
	}
	 public void show()
	{
		System.out.println("Method show");
	}
}