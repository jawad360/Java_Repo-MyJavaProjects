package npl;

import java.io.*;
import java.net.*;
public class UdpClientReverse
{
	public static void main(String args[])
	{
		try
		{
			//for sending to server
			byte[] buf=new byte[10000];
			DatagramSocket sock=new DatagramSocket(555);
			System.out.print("Enter The Setence ");
			String str=new BufferedReader(new InputStreamReader(System.in)).readLine();
			buf=str.getBytes();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			DatagramPacket pack=new DatagramPacket(buf,0,buf.length,IPAddress,777);
			sock.send(pack);

			//for receiving from server
			pack=new DatagramPacket(buf,buf.length);
			sock.receive(pack);
			str=new String(pack.getData(),0,pack.getLength());
			System.out.println("From Server "+str);
		}
		catch(IOException ie)
		{
		}
	}
}
