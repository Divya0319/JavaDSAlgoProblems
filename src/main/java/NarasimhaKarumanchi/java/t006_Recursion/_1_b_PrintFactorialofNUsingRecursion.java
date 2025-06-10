package main.java.NarasimhaKarumanchi.java.t006_Recursion;


public class _1_b_PrintFactorialofNUsingRecursion {

	static int fun1(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fun1(n - 1);
	}
	
	/*
	 *  converting above non-tail recursive to tail-recursive function
	 *  1. We added a parameter k to method, and initially passing it as 1 when making function call
	 *  2. In base case, instead of return 1, we replace with return k. (if we were to return 0, then in 
	 *  	replacement code, we write return (k-1).
	 *  3. In last line of method, where n is multiplied with recursion result, instead of that
	 *  	we multiply k with n in second parameter of recursion call.
	 */

	static int fun2(int n, int k) {
		if (n == 0 || n == 1) {
			return k;
		}
		return fun2(n - 1, k * n);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Factorial of " + n + " without tail recursion: " + fun1(n));
		System.out.println("Factorial of " + n + " with tail recursion: " + fun2(n, 1));

	}

}
