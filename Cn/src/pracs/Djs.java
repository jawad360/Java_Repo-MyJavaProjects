package pracs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Djs 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the no of nodes and edges");
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		int[][] grp = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				grp[i][j] = 9999;
		for(int i=0; i<e; i++)
		{
			
			System.out.println("Enter data for edge "+i+"source , destn, cost");
			int s = Integer.parseInt(br.readLine());
			int d = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			grp[s][d] = c;
			grp[d][s] = c;
		}
		
		int dist[] = new int[n];
		int pre[] = new int[n];
		String[] path = new String[n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			{
				dist[i] = 9999;
				pre[i] = -1;
			}
		dist[0] = 0;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(dist[i]+grp[i][j]<dist[j])
				{
					dist[j] = dist[i]+grp[i][j];
					pre[j] = i;
				}
		for(int i=0; i<n; i++)
		{
			int cur = i;
			
			do
			{
				path[i] = " - " +cur+path[i];
				cur = pre[cur];
			}
			while(cur!=-1);
			path[i] = path[i].substring(1);
			
			
		}
		for(int i = 0; i < n; i++)
		{
			if(i != 0)
			{
				System.out.println("The shortest path & its distance for node " + (i + 1) + " is:");
				System.out.print("Path: " + path[i]);
				System.out.println(" Distance: " + dist[i]);
			}
		}
	}
	
}
