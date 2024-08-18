package SingletonDesignPattern;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Utilities {

	public static void closeResource(Object object) {
		
	    ArrayList<Integer> numbers = new ArrayList<>();
	    numbers.add(10);
		try {
			if( null != object) {
				if(object instanceof FileOutputStream) {
					((FileOutputStream)object).close();
				}
			}
		}
		catch(Exception e) {
			
		}
		
	}
}
