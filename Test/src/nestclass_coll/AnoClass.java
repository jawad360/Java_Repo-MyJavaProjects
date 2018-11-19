package nestclass_coll;

public class AnoClass 
{
	public static void main(String[] args) 
	{
		Horse h = new Horse();
		h.show();
	}
}

class Animal
{
	void display()
	{
		System.out.println("class animal display");
	}
	void call()
	{
		System.out.println("class Animal call");
	}
}

class Horse
{
	Animal a = new Animal(){
		
		void display()
		{
			System.out.println("Overridden....");
		}
	};
	void show()
	{
		a.call();
		a.display();		//this show that it is a subclass
	}
}

