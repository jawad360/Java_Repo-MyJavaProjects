import java.util.Scanner;

class pattern1
{
	public static void main (String args[])
	{
		Scanner myScanner = new Scanner(System.in);
		int i,j,n;
		n = myScanner.nextInt();
		
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=i;j++)
				System.out.print(i);
			System.out.print("\n");
		
		}
	}
       
}