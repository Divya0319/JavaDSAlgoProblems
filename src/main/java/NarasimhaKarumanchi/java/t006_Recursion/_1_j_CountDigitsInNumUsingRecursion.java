package main.java.NarasimhaKarumanchi.java.t006_Recursion;

public class _1_j_CountDigitsInNumUsingRecursion {
	
	public static int countDigits(int n) {
		if(n / 10 == 0) return 1;
		
		return 1 + countDigits(n/10);
	}
	
	public static void main(String[] args) {
		int n = 6566;
		System.out.println("Number of digits in " + n + " are " + countDigits(n));
	}

}
