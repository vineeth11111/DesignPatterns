package SingletonDesignPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*         Since we made constructor as private it won't be visible for other classes
 *        But using reflection we can also access private constructor.
 *        So, therefore throwing exception on creating more than one object 
 *         if(null != singletonPattern) {
			throw new RuntimeException("You cannot create object more than once");
		}
 */
public class BreakingSingletonUsingReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/* We can break Singleton Design pattern using
		 *  1) Serialization & DeSerialization
		 *  2) Reflection
		 *  3) Clone
		 *  4) Multi threading
		 */
		
		Constructor<SingletonPattern> singletonPatternConstructor = SingletonPattern.class.getDeclaredConstructor();
		singletonPatternConstructor.setAccessible(true);
		SingletonPattern singletonPatternReference = singletonPatternConstructor.newInstance();
		System.out.println(singletonPatternReference.hashCode());
		System.out.println(SingletonPattern.getInstance().hashCode());

	}

}
