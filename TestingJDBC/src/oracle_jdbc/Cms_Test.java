package oracle_jdbc;
import java.sql.*;

public class Cms_Test 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		try
		{
			String user = "jawad";
			String pass = "123456";				//null:
			String url = "jdbc:oracle:thin:@localhost:1521:xe";		//dont know
			Class.forName ("oracle.jdbc.OracleDriver");	//No need require in older version..
			
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select distinct C.cab_no from  cab_booking B ,cab_details C	where   (B.DOB != '03/02/2015' OR B.status ='Cancelled') and C.cab_no = B.cab_no union select distinct C.cab_no from  cab_details C, cab_booking B where C.cab_no not in (select cab_no from cab_booking)");
			
			ResultSetMetaData md = rs.getMetaData();
			int no = md.getColumnCount();
			
			for(int i=1;i<=no;i++)
				System.out.print(md.getColumnName(i)+"\t\t");
			System.out.println();
			
			while(rs.next())
			{
				for(int i=1;i<=no;i++ )						//can be written as, if no of col not
					System.out.print(rs.getObject(i)+"\t\t");//known sop(rs.getInt("id")+rs.getString("name")+....select cust_id,PASSWORD from customer
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
