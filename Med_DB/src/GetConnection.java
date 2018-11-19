import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class GetConnection {

	/**
	 * @param args
	 */
	static String link= null;
	public Statement getConn() {
		Connection conn = null;
		Statement st = null;
		try
		{
			String user = "jawad";
			String pass = "123456";				//null:
			String url = "jdbc:oracle:thin:@localhost:1521:xe";		//dont know
			Class.forName ("oracle.jdbc.OracleDriver");	//No need require in older version..
			
			conn = DriverManager.getConnection(url, user, pass);
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return st;
		
	}

}
