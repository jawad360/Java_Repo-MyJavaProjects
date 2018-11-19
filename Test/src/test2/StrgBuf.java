package test2;

public class StrgBuf {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StringBuffer s = new StringBuffer("String buffer");
		StringBuffer s2 = s;		//same obj is modified
		s.append(" modi");
		System.out.println(s+"\n"+s2);
		
		String x= new String("String");
		String x2 = x;
		x = x.concat(" Modified");	//new obj is created and assign to x
		System.out.println(x+"\n"+x2);
	}

}
