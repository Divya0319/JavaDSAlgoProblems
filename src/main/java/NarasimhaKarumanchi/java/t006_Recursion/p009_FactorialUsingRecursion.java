package main.java.NarasimhaKarumanchi.java.t006_Recursion;

public class p009_FactorialUsingRecursion {
	
	public static long factorial(int n) {
		if(n == 0) 
			return 1;
		return n * factorial(n-1);
		
	}
	
	public static void main(String[] args) {
		int n = 6;
		System.out.println("Factorial of " + n + " is " + factorial(n));
	}

}
