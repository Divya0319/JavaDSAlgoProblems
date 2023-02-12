package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;

public class _1_o_PrintFrom1ToNUsingRecursion {

	static int fun1(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fun1(n - 1);
	}

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
