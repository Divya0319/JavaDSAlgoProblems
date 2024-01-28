package main.java.NarasimhaKarumanchi.java;

public class SingletonClassExample {
	private static SingletonClassExample s = null;
	
	public String str;
	
	private SingletonClassExample() {
		str = "it is an example of singleton class.";
	}
	
	public static synchronized SingletonClassExample getInstance() {
		if(s == null) {
			s = new SingletonClassExample();
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		SingletonClassExample a = SingletonClassExample.getInstance();
		SingletonClassExample b = SingletonClassExample.getInstance();
		SingletonClassExample c = SingletonClassExample.getInstance();

		System.out.println("Hashcode of x is "
                + a.hashCode());
		System.out.println("Hashcode of y is "
		                + b.hashCode());
		System.out.println("Hashcode of z is "
		                + c.hashCode());
		
		// Condition check
		if (a == b && b == c) {
		
		 // Print statement
		 System.out.println(
		     "Three objects point to the same memory location on the heap i.e, to the same object");
		}
		
		else {
		 // Print statement
		 System.out.println(
		     "Three objects DO NOT point to the same memory location on the heap");
		}
	}

}
