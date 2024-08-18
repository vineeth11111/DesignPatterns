package SingletonDesignPattern;

import java.io.Serializable;

public class SingletonPattern implements Serializable , Cloneable{
	
	//Eager Initialization
	//private static SingletonPattern singletonPattern = new SingletonPattern();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static volatile SingletonPattern singletonPattern = null;
	private Integer id;
	private String name;
	private static boolean single = true;
	
	

	@Override
	public String toString() {
		return "SingletonPattern [id=" + id + ", name=" + name + "]"+single ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static boolean isSingle() {
		return single;
	}

	public static void setSingle(boolean single) {
		SingletonPattern.single = single;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private SingletonPattern() {
		
		if(null != singletonPattern) {
			throw new RuntimeException("You cannot create object more than once");
		}
	}
	
	//Lazy initialization
	public static SingletonPattern getInstance() {
		//Double check mechanism
		if( null == singletonPattern ) {
			synchronized (SingletonPattern.class) {
				if(null == singletonPattern) {
					singletonPattern = new SingletonPattern();
				}
			}
		}
		return singletonPattern;
	}
	
	Object readResolve() {
		return singletonPattern;
	}

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//return super.clone();
		return singletonPattern;
	}
}
