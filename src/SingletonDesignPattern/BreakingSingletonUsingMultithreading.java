package SingletonDesignPattern;

public class BreakingSingletonUsingMultithreading implements Runnable {
	
	private SingletonPattern singletonPattern = null;

	@Override
	public void run() {
		
		singletonPattern = SingletonPattern.getInstance();
		System.out.println("Inside run method"+singletonPattern.hashCode());
	}
	
	public static void main(String[] args) {
		System.out.println("Main thread started .. !! ");

		BreakingSingletonUsingMultithreading runnable1 = new BreakingSingletonUsingMultithreading();
		
		BreakingSingletonUsingMultithreading runnable2 = new BreakingSingletonUsingMultithreading();
		
		Thread firstThread = new Thread(runnable1);
		Thread secondThread = new Thread(runnable2);
		firstThread.start();
		secondThread.start();
		
	}

}
