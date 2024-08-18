package SingletonDesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * In order to create only one object. 
 * you have to override readResolve method in the singleton class
 *  Object readResolve() {
		return singletonPattern;
	}
 */

public class BreakingSingletonUsingSerializationAndDeserialization {

	public static void main(String[] args) {
		
		SingletonPattern beforeSerialization = null;
		SingletonPattern afterSerialization = null;
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		//
		try
        {   
			 System.out.println("Object serialized started  x");
			 
			beforeSerialization = SingletonPattern.getInstance();
			beforeSerialization.setId(1000);
			beforeSerialization.setName("Before de");
			beforeSerialization.setSingle(true);
			
            //Saving of object in a file
			fileOutputStream = new FileOutputStream("output.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
             
            // Method for serialization of object
			objectOutputStream.writeObject(beforeSerialization);
             
			objectOutputStream.close();
            fileOutputStream.close();
             
            System.out.println("Object has been serialized");
            
            System.out.println("Object Deserialized started");
            
            fileInputStream = new FileInputStream("output.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            afterSerialization = (SingletonPattern) objectInputStream.readObject();
            System.out.println("Object has been Deserialized");
            fileInputStream.close();
            objectInputStream.close();
            
            System.out.println("Final outcome .. checking the reference before and after ");
            System.out.println("Reference before Serialization "+beforeSerialization.hashCode());
            System.out.println(beforeSerialization.toString());
            System.out.println("Reference after Deserialization "+afterSerialization.hashCode());
            System.out.println(afterSerialization.toString());
            
 
        }
         
        catch(Exception ex)
        {
            System.out.println("Exception is caught");
        }
		finally {
			if(null != fileOutputStream)Utilities.closeResource(fileOutputStream);
			if(null != objectOutputStream)Utilities.closeResource(objectOutputStream);
			if(null != fileInputStream)Utilities.closeResource(fileInputStream);
			if(null != objectInputStream)Utilities.closeResource(objectInputStream);
		}

	}

}
