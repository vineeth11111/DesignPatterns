package ChainOfResponsibility;

// In order to print all the stack trace from where error got generated.
// It uses a data structure called Stack.
public class ChainOfResponsiblityPattern {

	public static void main(String[] args) {
		m1();
	}
	
	public static void m1() {
		m2();
	}
	
    public static void m2() {
    	m3();
	}

     public static void m3() {
	   System.out.println(10/0);
    }
}
