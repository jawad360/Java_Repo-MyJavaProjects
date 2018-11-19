import java.util.Scanner;

class pattern2
{
	public static void main (String arg[])
	{
		int i,j,k,n;
		System.out.println("enter n");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=i-1;j++)
				System.out.print(" ");
			for(k=1;k<=6-i;k++)
				System.out.print("$");
			System.out.print("\n");
		
		}
	}
}