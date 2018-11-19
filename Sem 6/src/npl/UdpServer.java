package npl;

import java.io.*;
import java.net.*;
public class UdpServer
{
	public static void main(String args[])
	{
		DatagramSocket sock=null;
		try
		{
			//for receiving from client
			byte[] buf=new byte[10000];
			sock=new DatagramSocket(777);
			DatagramPacket pack=new DatagramPacket(buf,buf.length);
			sock.receive(pack);
			System.out.println("Datagram Packet Received");
			String str=new String(pack.getData(),0,pack.getLength());
			System.out.println("From Client "+str);
			
			//for Sending to client	
			int count=str.length();
			buf=(""+count).getBytes();
			pack=new DatagramPacket(buf,0,buf.length,InetAddress.getLocalHost(),555);
			sock.send(pack);
			System.out.println("Datagram Packet Sent");
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
