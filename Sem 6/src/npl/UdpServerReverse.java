package npl;

import java.io.*;
import java.net.*;
public class UdpServerReverse
{
	public static void main(String args[])
	{
		try
		{
			//for receiving from client
			byte[] buf=new byte[10000];
			DatagramSocket sock=new DatagramSocket(777);
			DatagramPacket pack=new DatagramPacket(buf,buf.length);
			sock.receive(pack);
			String str=new String(pack.getData(),0,pack.getLength());
			System.out.println("From Client "+str);
			
			//for Sending to client	
			String rev=new String(new StringBuffer(str).reverse());
			buf=rev.getBytes();
			pack=new DatagramPacket(buf,0,buf.length,InetAddress.getLocalHost(),555);
			sock.send(pack);
		}
		catch(IOException ie)
		{
		}
		
	}
}
