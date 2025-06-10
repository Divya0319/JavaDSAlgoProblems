package main.java.NarasimhaKarumanchi.java.t014_Misc;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestPrimeUsingSegmentedSieve {
	
	// Sieve of Eratosthenes algorithm
	public void simpleSieve(int limit, ArrayList<Integer> prime) {
		boolean[] mark = new boolean[limit+1];
		Arrays.fill(mark, true);  // although indices 0 and 1 are initialized as true, we don't care about them,
									// because we never use those values in our algo
		mark[0] = mark[1] = false;
		for(int i = 2; i*i < limit; i++) { // going from i = 2 to square root of n
			if(mark[i]) { //  isprime of an i is true, means it was never marked false so far
				for(int j = i * i; j < limit; j = j + i) { // we go to all multiples of i here, as follows, we first take i = 5(e.g.), 
														// then we go to j = 5 * 2 = 10, then we go j = 10 + 5 = 15, then 15 + 5, and so on
														// until j <= 100(e.g.)
					mark[j] = false;
				}
			}
			
		}
		
		 // Print all prime numbers and store them in prime
        for (int p=2; p<limit; p++)
        {
            if (mark[p] == true)
            {
                prime.add(p);
            }
        }
		
	}
	
	public void segmentedSieve(int n) {
		// Compute all primes smaller than or equal
        // to square root of n using simple sieve
		int limit = (int) (Math.floor(Math.sqrt(n))+1);
		ArrayList<Integer> prime = new ArrayList<>();
		simpleSieve(limit, prime);
		
		// Divide the range [0..n-1] in different segments
        // We have chosen segment size as sqrt(n).
		int low = limit;
		int high = 2 * limit;
		
		// While all segments of range [0..n-1] are not processed,
        // process one segment at a time
		while(low < n) {
			if(high >= n) 
				high = n;
				
			// To mark primes in current range. A value in mark[i]
            // will finally be false if 'i-low' is Not a prime,
            // else true.
			boolean mark[] = new boolean[limit+1];
			
			for(int i = 0; i < mark.length; i++) 
				mark[i] = true;
				
			// Use the found primes by simpleSieve() to find
            // primes in current range
			
			for(int i = 0; i < prime.size(); i++) {
				
				// Find the minimum number in [low..high] that is
                // a multiple of prime.get(i) (divisible by prime.get(i))
                // For example, if low is 31 and prime.get(i) is 3,
                // we start with 33.
				
				int loLim = (int) (Math.floor(low / prime.get(i)) * prime.get(i));
				if(loLim < low) 
					loLim += prime.get(i);
					
					/*  Mark multiples of prime.get(i) in [low..high]:
                    We are marking j - low for j, i.e. each number
                    in range [low, high] is mapped to [0, high-low]
                    so if range is [50, 100]  marking 50 corresponds
                    to marking 0, marking 51 corresponds to 1 and
                    so on. In this way we need to allocate space only
                    for range  */
					
				for (int j=loLim; j<high; j+=prime.get(i))
                    mark[j-low] = false;
				
				
			}
			
			// Numbers which are not marked as false are prime
            for (int i = low; i<high; i++) {
                if (mark[i - low] == true) {
                    System.out.print(i + "  ");
                }
            }
            		
      
            // Update low and high for next segment
            low  = low + limit;
            high = high + limit;
			
		}
	}
	
	public static void main(String[] args) {
		
		LargestPrimeUsingSegmentedSieve lp = new LargestPrimeUsingSegmentedSieve();
		lp.segmentedSieve(1000000000);
	}

}
