import java.util.Vector;


public class VectorTest 
{
	Vector v = new Vector();

	public static void main(String[] args)
	{
		VectorTest t = new VectorTest();
		t.display();
	}
	 void display()
	{
		v.addElement("display");
		System.out.println(v.elementAt(0));
	}

}
