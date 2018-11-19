package pracs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public final class Client1 {

	public static void main(String args[]) throws UnknownHostException, IOException
	{
		Socket client = new Socket("localhost",10007);
		
		DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		
		out.writeUTF("client speaking");
		out.writeUTF("client doen");
		out.writeUTF("done sending");

		String mes;
		while((mes = in.readUTF()).equals("Done Sending")!=true)
			System.out.println(mes);
		
		client.close();
	}

}
