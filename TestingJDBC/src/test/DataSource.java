package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.*;
public class DataSource {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String user = "a4895856_wordp";		//root
		String pass = "abc123";				//null
		String url = "jdbc:mysql://10.1.1.103:3306/a4895856_wordp";
		
		BasicDataSource bds = new BasicDataSource();
		
		bds.setUrl(url);
		bds.setUsername(user);
		bds.setPassword(pass);
		
		Connection conn = null;
		try
		{
			conn = bds.getConnection();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from wp_posts");
			
			ResultSetMetaData md = rs.getMetaData();
			int no = md.getColumnCount();
			
			for(int i=1;i<=no;i++)
				System.out.print(md.getColumnName(i)+"\t\t");
			System.out.println();
			
			while(rs.next())
			{
				for(int i=1;i<=no;i++ )						//can be written as, if no of col not
					System.out.print(rs.getObject(i)+"\t\t");//known sop(rs.getInt("id")+rs.getString("name")+....
				System.out.println();
			}
			rs.close();
			conn.close();
		}
		catch(Exception e)
		{
			
		}
	}

}
