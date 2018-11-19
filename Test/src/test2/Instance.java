package test2;

public class Instance {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Aa a= new Bb();
		//System.out.println(a instanceof Bb);	//true if extends
		
		Aa a = new Aa();
		Bb b = new Bb();
		//System.out.println(a instanceof Bb);	Error
		
	}

}
class Aa
{
	
}
class Bb 
{
	
}
