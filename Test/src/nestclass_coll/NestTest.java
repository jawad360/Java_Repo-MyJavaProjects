package nestclass_coll;

public class NestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		A.B a = new A().new B();
		a.go();
		new A().foo();
	}

}
class A
{
	class B
	{
		void go()
		{
			System.out.println("inside nested class");
			System.out.println(this+"  "+A.this);
		}
	}
	void foo()
	{
		B b = new B();
		b.go();
	}
}
