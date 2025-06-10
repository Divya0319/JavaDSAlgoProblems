package main.java.NarasimhaKarumanchi.java.t006_Recursion;


public class p004_SumOfDigitsUsingRecursion {

	/*
	 * If d is number of digits in n,
	 * Takes O(d) worst case time, 
	 * and O(d) auxiliary space for recursion stack(takes d+1 space actually)
	 */
	static int sumOfDigits(int n) {
		
//		if(n <= 0) // handling both cases here, when n becomes zero after reduction,
//						// and when given n is itself zero.
//		{ 
//			return 0; 
//		}
		
		if(n <= 9) // handling case here, when n becomes single digit after reduction,
				   // then we simply return n.
		{ 
			return n; 
		}
		
		/*
		 * Doing recursive call which removes last digit from number, and adds the value to this removed last digit 
		 * 
		 */
		return (sumOfDigits(n/10) + n % 10);
		
	}

	public static void main(String[] args) {
		int num = 12345;
		System.out.println("Sum of digits of " + num + " is " + sumOfDigits(num));

	}

}
