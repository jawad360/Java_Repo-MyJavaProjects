
public class EnumTest 
{
	public static void main(String[] args) 
	{
		Enum.LASER.display();		
		
		Enum e = Enum.INKJET;
		e.display();
	}

}
enum Enum
{
	LASER(10),INKJET(7),DOTMATRIX(5);
	private int p;

	private Enum(int x)
	{
		p=x;
	}
	public void display()
	{
		System.out.println("No of pages ="+p);
	}
}
