import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
  If serialVersionUId is changed in the serialized class, 
  	the application will throw java.io.InvalidClassException.
  
  Normally, we should change the serialVersionUID when the class is changed in such a way that its not backward compatible.
  - always create a static final long variable named serialVersionUID, otherwise some extra time is spent by the system creating it.
  - This field is like a version of the class.
  - changing the variable name will not throw any error while deserializing, but simply assign null value.
  - but if the field name is changed, and the field is also being accessed in a method, then error is thrown.
 */

public class DeserializeDemo
{
   public static void main(String [] args)
   {
      Employee e = null;
      try{
         FileInputStream fileIn = new FileInputStream("employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i){
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c){
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Address: " + e.address);
      System.out.println("SSN: " + e.SSN);
      System.out.println("Number: " + e.number);
     // e.mailCheck2();
    }
}
