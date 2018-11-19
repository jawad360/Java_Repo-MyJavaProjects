package test2;

public class OverStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//A a = new B();
		//A.disp();
		B b = new B(5);
		
	}

}
class A
{
	A()
	{
		System.out.println("A no para");
		disp();
	}
	A(int x )
	{
		System.out.println("Cons A ");
	}
	static void disp()
	{
		System.out.println("A");
	}
}
class B extends A
{
	B(int x)
	{
		System.out.println("cons B "+x);
	}
	static void disp()
	{
		
		System.out.println("B");
	}
	
}
