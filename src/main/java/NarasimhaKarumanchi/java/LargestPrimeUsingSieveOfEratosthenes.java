package main.java.NarasimhaKarumanchi.java;

import java.util.Arrays;

public class LargestPrimeUsingSieveOfEratosthenes {
	
	// Sieve of Eratosthenes algorithm
	public void largestPrime(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);  // although indices 0 and 1 are initialized as true, we don't care about them,
									// because we never use those values in our algo
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i*i <= n; i++) { // going from i = 2 to square root of n
			if(isPrime[i]) { //  isprime of an i is true, means it was never marked false so far
				for(int j = i * i; j <= n; j = j + i) { // we go to all multiples of i here, as follows, we first take i = 5(e.g.), 
														// then we go to j = 5 * 2 = 10, then we go j = 10 + 5 = 15, then 15 + 5, and so on
														// until j <= 100(e.g.)
					isPrime[j] = false;
				}
			}
			
		}
		
		for(int i = n; i >= 2; i--) {
			if(isPrime[i]) {
				System.out.println(i);
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		LargestPrimeUsingSieveOfEratosthenes lp = new LargestPrimeUsingSieveOfEratosthenes();
		lp.largestPrime(1000000000);
	}

}
