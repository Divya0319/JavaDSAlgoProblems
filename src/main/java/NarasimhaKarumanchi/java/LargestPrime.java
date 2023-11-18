package main.java.NarasimhaKarumanchi.java;

public class LargestPrime {
	
	public void largestPrime() {
		
		
		for(int i = 1000000000; i >= 2; i--) {
			if(isPrime(i)) {
				System.out.println(i);
				break;
			}
			
		}
		
		
	}
	
	
	// gives if number is prime
	public boolean isPrime(int n) {
		for(int i = 2; i*i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		LargestPrime lp = new LargestPrime();
		lp.largestPrime();
	}

}
