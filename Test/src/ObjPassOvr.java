
public class ObjPassOvr {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{				
		Ab a = new B();
		B b = new B();
		b.display(a);
		
		Ab ab = new Ab();
		B ba = (B)ab;
	}

}
class Ab
{
	void display(Ab a)
	{
		System.out.println("A");
	}
}
class B extends Ab
{
	void display(B b)
	{
		System.out.println("B");
	}
}
