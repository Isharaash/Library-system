

package abc.library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Book {
    private String BookName;

    private int BookAuthorId ;
    private int Isbn ;
    private int Page ;

    public Book() {
    }
      DBConnection objcon=new DBConnection();
    PreparedStatement pst;

    public Book(String BookName, int BookAuthorId, int Isbn, int Page) {
        this.BookName = BookName;
        this.BookAuthorId = BookAuthorId;
        this.Isbn = Isbn;
        this.Page = Page;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public int getBookAuthorId() {
        return BookAuthorId;
    }

    public void setBookAuthorId(int BookAuthorId) {
        this.BookAuthorId = BookAuthorId;
    }

    public int getIsbn() {
        return Isbn;
    }

    public void setIsbn(int Isbn) {
        this.Isbn = Isbn;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int Page) {
        this.Page = Page;
    }
    


    
//    public String[] getCategoryName()
//       {
//           String BookCategorynName[]=new String[10];
//           try{
//               String SQL="select BookCategorynName from BookCategory";
//               
//               ResultSet rs=objcon.SelectValuee(SQL);
//               int index=0;
//               while (rs.next())
//               {
//                  BookCategorynName[index]=rs.getString("BookCategorynName");
//                  index++;
//               }
//           }
//           catch(Exception ex)
//           {
//                 System.out.println("Error Getting BookCategorynName"+ex);
//           }
//           return BookCategorynName;
//       }
//       
//       
//       
//       
//         public String BookCategoryId(String BookCategorynName){
//        
//        String BookCategoryId=null;
//        try{
//            String SQL="select BookCategoryId from BookCategory where BookCategorynName='"+BookCategorynName+"'";
//           ResultSet rs=objcon.SelectValuee(SQL);
//        
//        while(rs.next()){
//           BookCategoryId=rs.getString(" BookCategoryId ");
//        }
//        
//    }
//    catch(Exception ex)
//      {
//                 System.out.println("Error Getting  BookCategoryId "+ex);
//           }
//      return BookCategoryId;
//}
         
         
         
      public String[] getAuthorName()
       {
           String BookAuthorName[]=new String[10];
           try{
               String SQL="select BookAuthorName from BookAuthor";
               
               ResultSet rs=objcon.SelectValuee(SQL);
               int index=0;
               while (rs.next())
               {
                  BookAuthorName[index]=rs.getString("BookAuthorName");
                  index++;
               }
           }
           catch(Exception ex)
           {
                 System.out.println("Error Getting BookAuthorName"+ex);
           }
           return BookAuthorName;
       }
            
             
         public String BookAuthorId(String BookAuthorName){
        
        String BookAuthorId=null;
        try{
            String SQL="select BookAuthorId from BookAuthor where  BookAuthorName='"+ BookAuthorName+"'";
           ResultSet rs=objcon.SelectValuee(SQL);
        
        while(rs.next()){
          BookAuthorId=rs.getString("BookAuthorId");
        }
        
    }
    catch(Exception ex)
      {
                 System.out.println("Error Getting  BookAuthorId "+ex);
           }
      return BookAuthorId;
}
         
 public int addBook()
    {
        int noRows=0;
        String SQL="insert into Book (BookName,BookAuthorId,Isbn,Page) values('"+getBookName()+"',"+getBookAuthorId()+","+getIsbn()+","+getPage()+")";
        
     try{
    noRows=objcon.execute_UpdateMethod(SQL);
      }
    
    catch(Exception ex)
    {
        System.out.println("Error inserting data"+ex);
        }
    return noRows;
    
}       
}
