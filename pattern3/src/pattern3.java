import java.util.Scanner;

class pattern3
{
	public static void main(String args[])
	{
		Scanner d = new Scanner(System.in);
		char n='A',i,j;
		int x;
		System.out.println("enter n");
		x = d.nextInt();
		for(i=1;i<=x;i++)
		{
			for(j=1;j<=i;j++)
			{
			System.out.print(" "+n);
			n++;
			}
		System.out.print("\n");	
		}
	
	}
}
