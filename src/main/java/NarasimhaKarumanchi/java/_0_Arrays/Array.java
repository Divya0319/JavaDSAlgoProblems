package main.java.NarasimhaKarumanchi.java._0_Arrays;

public class Array {

	public static int sumN(int n , int k) {

		if (n == 0) {
			return k-1;
		}

		return sumN(n - 1, k+n);
	}

	public static void main(String[] args) {
		
		int n = 6;
		
		System.out.println("Sum of " + n + " natural no.s is : " + sumN(n, 1));

	}

}
