package pracs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dvr 
{
	static int graph[][],rt[][],via[][];
	static int n,e;
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the no of nodes and edges");
		n = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());

		graph = new int[n][n];
		rt = new int[n][n];
		via = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(i==j)
					graph[i][j] = 0;
				else
					graph[i][j]=9999;
		for(int i=0; i<e; i++)
		{
			System.out.println("Enter data for edge "+i+"source , destn, cost");
			int s = Integer.parseInt(br.readLine());
			int d = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			graph[s][d] = c;
			graph[d][s] = c;
		}
		dvrCal("initial table");
		
	}
	static void dvrCal(String string) 
	{
		System.out.println();
		initCal();
		updateT();
		System.out.println(string);
		disp();
	}
	static void disp() 
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
		
				System.out.print(rt[i][j]+"  ");
			System.out.println();
		}
	}
	static void updateT() 
	{
		int k=0;
		for(int i=0; i<4*n; i++)
		{
			update(k);
			k++;
			if(k==n)
				k=0;
		}
	}
	static void update(int k) 
	{
		int dis, intr;
		for(int i=0; i<n; i++)
		{
			if(graph[k][i]!=9999)
			{
				dis = graph[k][i];
				for(int j=0; j<n; j++)
				{
					intr = rt[i][j];
					if(via[i][j]==k)
						intr = 9999;
					if(dis+intr < rt[k][j])
					{
						rt[k][j] = dis+intr;
						via[k][j] = i;
					}
				}
			}
		}
	}
	private static void initCal() 
	{
		for(int i=0; i<n; i++)
		{	for(int j=0; j<n; j++)
			{	if(i==j)
				{
					rt[i][j] = 0;
					via[i][j] = i;
				}
				else
				{
					rt[i][j] = 9999;
					via[i][j] = 9999;
				}
			}
		}
	}

}
