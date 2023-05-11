package main.java.NarasimhaKarumanchi.java._5_Recursion;

public class _1_k_SumNosFrom1toNUsingRecursion {
	
	public static int recursiveSum(int n) {
		if(n == 0 || n == 1)
			return n;
		
		return n + recursiveSum(n - 1);
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Sum of numbers from 1 to " + n + " is " + recursiveSum(n));
	}

}
