package pracs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Crc {


	public static void main(String[] args) throws IOException 
	{
		String data,gen,code;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter data and gen");
		data = br.readLine();
		gen = br.readLine();
		
		code = data;
		while(code.length()< (data.length()+gen.length()-1))
			code = code + "0";
		code = data + div(code,gen);
		System.out.println("Code : "+code);
		
		System.out.println("Enter rec code");
		String rcode = br.readLine();
		
		if(Integer.parseInt(div(rcode,gen))==0)
			System.out.println("NO error");
		else
			System.out.println("ERROR");
		
	}

	static String div(String code, String gen) 
	{
		String result = "";
		String rem = "";
		
		int ptr = gen.length();
		
		result = code.substring(0,ptr);
		
		for(int i=0; i<gen.length(); i++)
		{
			if(result.charAt(i)==gen.charAt(i))
				rem  += "0";
			else
				rem += "1";
		}
		while(ptr<code.length())
		{
			if(rem.charAt(0)=='0')
			{
				rem = rem.substring(1);
				rem += String.valueOf(code.charAt(ptr));
				ptr++;
			}
			result = rem;
			rem = "";
			for(int i=0; i<gen.length(); i++)
			{
				if(result.charAt(i)==gen.charAt(i))
					rem  += "0";
				else
					rem += "1";
			}
			
		}
		
		
		
		return rem.substring(1);
	}

}
