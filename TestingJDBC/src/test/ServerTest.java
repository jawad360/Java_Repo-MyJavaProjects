package test;
import java.sql.*;

public class ServerTest 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		try
		{
			String user = "u506777400_test";		//root
			String pass = "test123";				//null
			String url = "jdbc:mysql://31.170.166.15:3306/u506777400_test";
			Class.forName("com.mysql.jdbc.Driver");	//No need require in older version..
			
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from item");
			
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
			System.out.println(e);
		}
		
		
	}

}
