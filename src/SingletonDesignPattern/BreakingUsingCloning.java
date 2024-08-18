package SingletonDesignPattern;

/*
 * Here also we need to override clone method
 * @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//return super.clone(); // default creates shallow cloning
		return singletonPattern;
	}
 */

public class BreakingUsingCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		SingletonPattern singletonPattern1 = SingletonPattern.getInstance();
		
		SingletonPattern singletonPattern2 = (SingletonPattern) singletonPattern1.clone();
		
		System.out.println(singletonPattern1.hashCode());
		
		System.out.println(singletonPattern2.hashCode());
	}
}
