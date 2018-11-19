
public class AnoClass
{

	
	public static void main(String[] args) 
	{
		Ano a = new Ano();
		 a.show();
		
	}
	void print1()
	{
		System.out.println("ano extendening");
	}

}
class Ano
{
	public void display()
	{
		System.out.println("display outer");
	}
	public void show()
	{
		System.out.println("display outer");
		System.out.println(
		new AnoClass()
		{
			public String  toString()
			{
				print1();	//shows that it 
							//is extending AnoClass
				return "Ano class";
				
			}
		});
		AnoClass c = new AnoClass(){};	//Anoy class
	}
	
}