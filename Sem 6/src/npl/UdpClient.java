package npl;

import java.io.*;
import java.net.*;
public class UdpClient
{
	public static void main(String args[])
	{
		DatagramSocket sock=null;
		try
		{
			//for sending to server
			byte[] buf=new byte[10000];
			sock=new DatagramSocket(555);
			System.out.print("Enter The Setence ");
			String str=new BufferedReader(new InputStreamReader(System.in)).readLine();
			buf=str.getBytes();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			DatagramPacket pack=new DatagramPacket(buf,0,buf.length,IPAddress,777);
			sock.send(pack);
			System.out.println("Datagram Packet Sent");

			//for receiving from server
			pack=new DatagramPacket(buf,buf.length);
			sock.receive(pack);
			str=new String(pack.getData(),0,pack.getLength());
			System.out.println("From Server\n The Number of Letters in The sentence is "+str);	
		}
		catch(IOException ie)
		{
			System.err.println("Error Connecting");
		}
		finally
		{
			sock.close();
		}
	}
}
