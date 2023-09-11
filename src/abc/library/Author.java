
package abc.library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class Author {
   private int BookAuthorId;
   private String BookAuthorName;

    public Author() {
    }
   DBConnection objcon=new DBConnection();
    PreparedStatement pst;

    public Author(int BookAuthorId, String BookAuthorName) {
        this.BookAuthorId = BookAuthorId;
        this.BookAuthorName = BookAuthorName;
    }

    public int getBookAuthorId() {
        return BookAuthorId;
    }

    public void setBookAuthorId(int BookAuthorId) {
        this.BookAuthorId = BookAuthorId;
    }

    public String getBookAuthorName() {
        return BookAuthorName;
    }

    public void setBookAuthorName(String BookAuthorName) {
        this.BookAuthorName = BookAuthorName;
    }

    public int addAuthor()
    {
        int noRows=0;
        String SQL="insert into BookAuthor values('"+getBookAuthorName()+"')";
        
    
    try{
    noRows=objcon.execute_UpdateMethod(SQL);
      }
    
    catch(Exception ex)
    {
        System.out.println("Error inserting data"+ex);
        }
    return noRows;
    
} 
    
           public ResultSet SearchAllAuthor()
     {
         int c;
         ResultSet rs=null;
         
        
         
         try
         { 
              String SQL="Select * from BookAuthor";
                 rs=objcon.SelectValuee(SQL);
                 rs=pst.executeQuery();
                 ResultSetMetaData rsd=rs.getMetaData();
                 c =rsd.getColumnCount();
          }
            
             catch(Exception ex){
                    System.out.print("Error View All Author"+ex);
                     
                     }
             return rs;
     }   
    
     public int UpdateAuthor()
     {
         int noRows=0;
         
         String SQL="update BookAuthor set BookAuthorName='"+getBookAuthorName()+"' where BookAuthorId="+getBookAuthorId()+"";
                 
         
         try{
             noRows=objcon.execute_UpdateMethod(SQL);
         }
         catch(Exception ex)
         {
             System.out.println("Error Updateing Author Details"+ex.toString());
         }
 
         return noRows;
     }
    
     
       public int DeleteAuthor()
     {
         int noRows=0;
         
         String SQL="delete from BookAuthor where BookAuthorId="+getBookAuthorId()+"";
                 
         
         try{
             noRows=objcon.execute_UpdateMethod(SQL);
         }
         catch(Exception ex)
         {
             System.out.println("Error Delete Author"+ex.toString());
         }
 
         return noRows;
     }
    
}
