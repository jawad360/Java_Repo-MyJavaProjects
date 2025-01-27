package npl;

import java.net.*; 
import java.io.*; 
public class TCPConcurrentServer extends Thread
{ 
	static boolean serverContinue = true;
	Socket clientSocket;
	public static void main(String[] args) throws IOException 
	{ 
		ServerSocket serverSocket = null; 
		try 
		{
			serverSocket = new ServerSocket(10008); 
			System.out.println ("Connection Socket Opened");
			try 
			{ 
				while (serverContinue)
				{
					serverSocket.setSoTimeout(10000);
					System.out.println ("Waiting for Connection");
							try 
							{
								new TCPConcurrentServer(serverSocket.accept()); 
							}
							catch (SocketTimeoutException ste)
							{
								System.out.println ("Timeout Occurred");
							}
				}
			} 
			catch (IOException e) 
			{		 
				System.err.println("Accept failed."); 
				System.exit(1); 
			} 
		} 
		catch (IOException e) 
		{ 
			System.err.println("Could not listen on port: 10008."); 
			System.exit(1); 
		} 
		finally
		{
			try 
			{
				System.out.println ("Closing Server Connection Socket");
				serverSocket.close(); 
			}
			catch (IOException e)
			{ 
				System.err.println("Could not close port: 10008."); 
				System.exit(1); 
			} 
		}
	}     
	private TCPConcurrentServer (Socket clientSoc)
	{
		clientSocket = clientSoc;
		start();
	}
	public void run()
	{
		System.out.println ("New Communication Thread Started");
		try 
		{ 
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
			BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream())); 
			String inputLine; 
			while ((inputLine = in.readLine()) != null) 
			{ 
				System.out.println ("Server: " + inputLine); 
				if (inputLine.equals("?")) 
					inputLine = new String ("\"Bye.\" ends Client, " +"\"End Server.\" ends Server");
				out.println(inputLine.toUpperCase()); 
				if (inputLine.equalsIgnoreCase("Bye")) 
					break; 
				if (inputLine.equalsIgnoreCase("End Server")) 
					serverContinue = false; 
			} 
			out.close(); 
			in.close(); 
			clientSocket.close(); 
		} 
		catch (IOException e) 
		{ 
			System.err.println("Problem with Communication Server");
			System.exit(1); 
		} 
	}
} 