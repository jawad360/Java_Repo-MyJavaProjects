
public class ObjPass 
{
	int x =10;

	public static void main(String[] args) 
	{
		ObjPass o1 = new ObjPass();
		ObjPass o2 = new ObjPass();
		o2=o1;
		
		o2=call(o1);
		System.out.println(o1.x);		//note op 12
		System.out.println(o2.x);		//note op 12 op 15 if returning obj
		
		
										//Stack and heap necessary
	}
	static ObjPass call(ObjPass o)
	{
		o.x = 12;
		
		o=new ObjPass();
		o.x=15;
		return o;
		
	}

}
