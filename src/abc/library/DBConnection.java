
package abc.library;
import java.sql.*;
public class DBConnection {
      public Connection getConnection()
  {
      Connection con=null;
   try
   {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:ABCLibrary"," ","");
           System.out.println("Connecting to the Data base");
   }
   catch(ClassNotFoundException | SQLException ex)
   {
       System.out.println("Error connecting to database"+ex);
   }
   return con;
   
  }  
     public static void main(String args[]) {
             DBConnection obj=new DBConnection();
             Connection con=obj.getConnection();
     }
     
     public int execute_UpdateMethod(String SQL)throws Exception
     {
           Connection conn=getConnection();
           Statement st=conn.createStatement();
           System.out.println(""+SQL);
           
           int noRows=st.executeUpdate(SQL);
           conn.close();
           return noRows;
           
     }
     
      public ResultSet SelectValuee(String SQL)throws Exception
     {
           Connection conn=getConnection();
           PreparedStatement stmt=conn.prepareStatement(SQL);
           ResultSet rs=stmt.executeQuery();
           System.out.println(""+SQL);
           return rs;
           
     }
    
}
