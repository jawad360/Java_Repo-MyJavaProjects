import java.io.*;
 
public class TestClass {
 
  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
   
    String strFilePath = "C://demo.ser";
    ObjectOutputStream output;
   
     try
     {
       /*
        * To append output to a file, use
        * FileOutputStream(String file, booean blnAppend) or
        * FileOutputStream(File file, booean blnAppend) constructor.
        *
        * If blnAppend is true, output will be appended to the existing content
        * of the file. If false, file will be overwritten.
        */
       
      FileOutputStream fos = new FileOutputStream(strFilePath, true);
      
      output=new  ObjectOutputStream(fos);
      
      String strContent = "Append output to a file example\n";
     
     //.writeObject(strContent);
     
      /*
       * Close FileOutputStream using,
       * void close() method of Java FileOutputStream class.
       *
       */
     
       output.close();
     
     }
     catch(FileNotFoundException ex)
     {
      System.out.println("FileNotFoundException : " + ex);
     }
     catch(IOException ioe)
     {
      System.out.println("IOException : " + ioe);
     }
     
     ObjectInputStream input = new ObjectInputStream(new FileInputStream(strFilePath));
     
     String str;
    for(int i=0;i<2;i++)
     {
    str=(String) input.readObject();
     
     
    System.out.println(str);
     }   
  }
}