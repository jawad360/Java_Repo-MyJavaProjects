class gcdlcm
{
	public static void main(String args[])
	{
		int a=13,b=71,i,gcd=0;
		for(i=1;i<=a*b;i++)
			if(i%a==0 && i%b==0)
			{	
		    System.out.println("lcm="+i);
		    break;
			}
		for(i=1;i<=a;i++)
			if(a%i==0 && b%i==0)
			gcd=i;	
		System.out.println("gcd="+gcd);
	}
}