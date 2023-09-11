

package abc.library;
import java.sql.ResultSet;
public class UserInfo {
   
    private String userName;
    private String password;
    private String userType;

    public UserInfo() {
    }
    DBConnection objcon=new DBConnection();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

   
   
    
      public boolean ValidateLogin()
     {
         ResultSet rs=null;
         String SQL="Select * from UserTable where UserName='"+getUserName()+"' and Password='"+getPassword()+"';";
         
         try{ 
                 rs=objcon.SelectValuee(SQL);
             if(rs.next())
             {
                 setUserType(rs.getString("UserType"));
                 
             }
             else{
                 return false;
             }
         }
             catch(Exception ex){
                    System.out.print("Error Validating user"+ex);
                     
                     }
             return true;
     }
    
    
    
    
}
