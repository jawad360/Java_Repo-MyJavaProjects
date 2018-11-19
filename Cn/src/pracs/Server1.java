package pracs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.*;

public class Server1 {

	public static void main(String[] args) throws IOException 
	{
		ServerSocket sock = new ServerSocket(10007);
		Socket socket = sock.accept();
		
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		String mes;
		while((mes = in.readUTF()).equals("Done Sending")!=true)
			System.out.println(mes);
		
		out.writeUTF("SErver speaking");
		out.writeUTF("SErver Done");
		out.writeUTF("Done sending");

		sock.close();
		
	}

}
