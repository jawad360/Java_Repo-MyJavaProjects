package credit_check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//changes made
public class CreditCheck 
{
	String un,pass,doc;
	int c,amount,acc;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws IOException
	{
		new CreditCheck().start();
	}
	void start() throws IOException
	{
		System.out.println("Login");
		System.out.println("Enter Username and Password");
		
		un = br.readLine();
		pass = br.readLine();
		
		System.out.println("Type of Loan\n1.Personal Loan\n2.Educational Loan");
		int ch1 = Integer.parseInt(br.readLine());
		
		if(ch1==1)
		{
			basic(1);
		}
		else
		{
			basic(2);
		}
	}
	void basic(int x) throws NumberFormatException, IOException 
	{
		int ch;
		
		System.out.println("Enter amount");
		amount = Integer.parseInt(br.readLine());
		
		System.out.println("Loan Taken Before \n1.Yes\n2.No");
		ch = Integer.parseInt(br.readLine());
		if(ch==1)
		{
			System.out.println("Loan paid on time\n1.Yes\n2.No");
			int ch1 = Integer.parseInt(br.readLine());
			if(ch1==1)
			{
				c += 3;
			}
			else
			{
				c--;
				System.out.println("No of days delayed:");
				if(Integer.parseInt(br.readLine()) > 10)
				{
					c -= 3;
				}
			}
		}
		else
		{
			c++;
		}
		
		if(x==1)
			personal();
		else
			edu();	
	}
	
	void personal() throws  IOException
	{
		System.out.println("Type of job\n1.Business\n2.Employeed");
		int emp = Integer.parseInt(br.readLine());
		System.out.println("Monthly income");
		
		if(Integer.parseInt(br.readLine()) > 40000)
			c  += 3;
		else
			c++;
		
		System.out.println("House:\n1.On Rent\n2.Ownedn");
		if(Integer.parseInt(br.readLine()) == 2)
			c+=2;
		else
			c--;
		System.out.println("Submit your documents file");
		doc = br.readLine();
		
		if(c>=5)
		{
			System.out.println("Congratulation..Loan granted");
			System.out.println("Enter your account no");
			acc = Integer.parseInt(br.readLine());
		}
		else
		{
			System.out.println("Sorry...request rejected");
		}
	}
	void edu() throws IOException 
	{
		String un,coll;
		int rank;
		System.out.println("Enter name of your university");
		un = br.readLine();
		
		System.out.println("Enter name of your colleger");
		coll = br.readLine();
		
		System.out.println("Enter official ranking of your institute");
		rank = Integer.parseInt(br.readLine());
		
		if(rank<=30)
		{
			System.out.println("Congratulation..Loan granted");
			System.out.println("Enter your account no");
			acc = Integer.parseInt(br.readLine());
		}
		else
		{
			System.out.println("Parent's Monthly income");
			
			if(Integer.parseInt(br.readLine()) > 50000)
				c  += 3;
			else
				c++;
			
			System.out.println("House:\n1.Hostel\n2.Ownedn");
			if(Integer.parseInt(br.readLine()) == 2)
				c+=2;
			else
				c--;
			
			System.out.println("Enter fees paid per year");
			if(Integer.parseInt(br.readLine()) >= 60000)
				c++;
			
			System.out.println("Aggregate of previous year in percentage");
			
			if(Integer.parseInt(br.readLine()) >= 70)
				c++;
			
			System.out.println("Submit your academic performance with fee receipe");
			doc = br.readLine();
			
			if(c>=5)
			{
				System.out.println("Congratulation..Loan granted");
				System.out.println("Enter your account no");
				acc = Integer.parseInt(br.readLine());
			}
			else
			{
				System.out.println("Sorry...request rejected");
			}
		}
	}
}