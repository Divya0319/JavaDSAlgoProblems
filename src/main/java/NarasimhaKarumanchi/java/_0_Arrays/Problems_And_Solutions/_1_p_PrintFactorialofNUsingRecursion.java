package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;


public class _1_p_PrintFactorialofNUsingRecursion {


	static void fun1(int n) {

		if(n == 0)
			return;
		fun1(n-1);
		System.out.println(n);
	}
	static void fun2(int n, int k) {

		if(n == 0)
			return;
		System.out.println(k);
		fun2(n-1, k+1);
	}

	public static void main(String[] args) {
		System.out.println("Printing 1 to n without tail recursion: ");
		fun1(5);
		System.out.println("Printing 1 to n with tail recursion: ");
		fun2(5, 1);

	}

}
