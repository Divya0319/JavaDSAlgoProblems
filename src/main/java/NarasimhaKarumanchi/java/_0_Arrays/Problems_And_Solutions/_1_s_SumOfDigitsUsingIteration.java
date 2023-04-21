package main.java.NarasimhaKarumanchi.java._0_Arrays.Problems_And_Solutions;


public class _1_s_SumOfDigitsUsingIteration {

	/*
	 * Takes O(d) worst case time 
	 * and O(1) auxiliary space as no recursive calls
	 */
	
	/*
	 * Initialized res as 0
	 * Then running loop while n > 0
	 * Inside loop, simply adding last digit to res
	 * And then, removing last digit from n
	 * 
	 * Outside the loop, simply return res
	 */
	static int sumOfDigitsIterative(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		
		return sum;
		
	}

	public static void main(String[] args) {
		int num = 5678;
		System.out.println("Sum of digits of " + num + " is " + sumOfDigitsIterative(num));

	}

}
