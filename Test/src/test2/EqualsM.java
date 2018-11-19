package test2;

public class EqualsM {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String x1 = "World";
		String y1 = "World";
		System.out.println("x1==y1 "+(x1==y1));
		System.out.println("x1 equals y1 "+x1.equals(y1));

		String s = new String("Hello");
		String s2 = new String("Hello");
		String s3 = s;
		
		System.out.println("s==s3 "+(s==s3));
		System.out.println("s equals s2 "+s.equals(s2));
		System.out.println("s==s2 "+(s==s2));
		
		int x=1,y=1;
		System.out.println("x==y "+(x==y));
		//System.out.println(x.equals(y));


		Integer m = new Integer(1);
		Integer n = new Integer(1);
		
		System.out.println("m==n "+(m==n));
		System.out.println("m equals n "+m.equals(n));

		Eq q = new Eq(5);
		Eq q1 = new Eq(5);
		
		System.out.println("q==q1 "+(q==q1)+" q equals q1 "+q.equals(q1));  //before overriding equals =>false
		q1=q;
		System.out.println("q==q1 "+(q==q1)+" q equals q1 "+q.equals(q1));



	}

}
class Eq
{
	int x;
	Eq(int y)
	{
		x=y;
	}
	public boolean equals(Object o)
	{
		if(o instanceof Eq && ((Eq)o).x == this.x)
			return true;
		else
			return false;
		
	}
	public int hashCode()
	{
		return x*10;
	}
}
/*
 * op
 x1==y1 true
x1 equals y1 true
s==s3 true
s equals s2 true
s==s2 false
x==y true
m==n false
m equals n true
q==q1 false q equals q1 true
q==q1 true q equals q1 true
*/
