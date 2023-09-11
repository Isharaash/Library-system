

package abc.library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Category {
  private int BookCategoryId;
   private String BookCategorynName;

    public Category() {
    }
    DBConnection objcon=new DBConnection();
    PreparedStatement pst;

    public Category(int BookCategoryId, String BookCategorynName) {
        this.BookCategoryId = BookCategoryId;
        this.BookCategorynName = BookCategorynName;
    }

    public int getBookCategoryId() {
        return BookCategoryId;
    }

    public void setBookCategoryId(int BookCategoryId) {
        this.BookCategoryId = BookCategoryId;
    }

    public String getBookCategorynName() {
        return BookCategorynName;
    }

    public void setBookCategorynName(String BookCategorynName) {
        this.BookCategorynName = BookCategorynName;
    }

    public int addCategory()
    {
        int noRows=0;
        String SQL="insert into BookCategory values('"+getBookCategorynName()+"')";
        
    
    try{
    noRows=objcon.execute_UpdateMethod(SQL);
      }
    
    catch(Exception ex)
    {
        System.out.println("Error inserting data"+ex);
        }
    return noRows;
    
} 
    
    
    
    
          public ResultSet SearchAllCategory()
     {
         int c;
         ResultSet rs=null;
         
        
         
         try
         { 
              String SQL="Select * from BookCategory";
                 rs=objcon.SelectValuee(SQL);
                 rs=pst.executeQuery();
                 ResultSetMetaData rsd=rs.getMetaData();
                 c =rsd.getColumnCount();
          }
            
             catch(Exception ex){
                    System.out.print("Error View All BookCategory"+ex);
                     
                     }
             return rs;
     }
          
      
          
      public int UpdateCategory()
     {
         int noRows=0;
         
         String SQL="update BookCategory set BookCategorynName='"+getBookCategorynName()+"' where BookCategoryId="+getBookCategoryId()+"";
                 
         
         try{
             noRows=objcon.execute_UpdateMethod(SQL);
         }
         catch(Exception ex)
         {
             System.out.println("Error Updateing Book Details"+ex.toString());
         }
 
         return noRows;
     }
    
         public int DeleteCategory()
     {
         int noRows=0;
         
         String SQL="delete from BookCategory where BookCategoryId="+getBookCategoryId()+"";
                 
         
         try{
             noRows=objcon.execute_UpdateMethod(SQL);
         }
         catch(Exception ex)
         {
             System.out.println("Error Updateing Book Details"+ex.toString());
         }
 
         return noRows;
     }
    
       

}
