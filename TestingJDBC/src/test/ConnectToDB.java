package test;

import java.sql.*;

public class ConnectToDB 
{
   public static void main(String[] args) 
   {
      Connection conn = null;
      try 
      {
         String userName = "root";
         String password = null;
         String url = "jdbc:mysql://localhost/library";
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection(url, userName, password);
         System.out.println("Database connection successful.");
      }
      catch (Exception e) 
      {
         System.out.println("Cannot connect to database.");
      }
      finally 
      {
         if (conn != null) 
         {
            try 
            {
               conn.close();
               System.out.println("Database connection closed.");
            }
            catch (Exception e) 
            {
               System.out.println("Database connection cannot be closed.");
            }
         }
      }
   }
}