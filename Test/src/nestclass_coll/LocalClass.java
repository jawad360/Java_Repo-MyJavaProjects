package nestclass_coll;

public class LocalClass {

	String y = "eeee";
	public static void main(String[] args) 
	{
		Out o = new Out();
		o.zoo();
	}

}
class Out
{
	String x = "CAll";
	void zoo()
	{
		String s = "hello ";	//cant access this string in local class
		class In
		{
			void call()
			{
				LocalClass c = new LocalClass();
				System.out.println("Loacal class"+x+c.y);
			}
		}
		
		In n = new In();
		n.call();
		
	}
}
