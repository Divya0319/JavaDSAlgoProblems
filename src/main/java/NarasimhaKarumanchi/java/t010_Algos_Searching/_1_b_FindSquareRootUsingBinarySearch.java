package main.java.NarasimhaKarumanchi.java.t010_Algos_Searching;

public class _1_b_FindSquareRootUsingBinarySearch {
	
	// method which calculates square root of a number up to given precision
	public double sqrt(int num, int precision) {
			
			int start = 0, end = num;
			
			// variable to store the answer
			double ans = 0.0;
			
			// for computing integral part
	        // of square root of number
			while(start <= end) {
				
				int mid = start + (end-start)/ 2;
				
				int square = mid * mid;
				
				if(square == num) {
					ans = mid;
					break;
				}
				
				// mid square is less than our number
				// means integral part lies on right side of mid
				// so, we need to increment start
				// and our mid can be potential answer
				if(square < num) {
					start = mid + 1;
					ans = mid;
				}
				
				else {
					// mid square is greater than our number
					// means integral part lies on left side of mid
					// so, we need to decrement mid
					end = mid - 1;
				}
				
			}
			
			// For computing the fractional part
	        // of square root upto given precision
			double increment = 0.1;
			for(int i = 0; i < precision; i++) {
				while(ans * ans <= num) {
					ans += increment;
				}
				
				// loop terminates when ans * ans > number
				ans = ans - increment;
				increment = increment / 10;
			}

			return (double) ans;
		}
	
		public static void main(String[] args) {
			
			_1_b_FindSquareRootUsingBinarySearch mainClass = new _1_b_FindSquareRootUsingBinarySearch();
			int inp = 2;
			
			int precision = 9;
			
			double sqrt = mainClass.sqrt(inp, precision);
	
			System.out.println("Square root of " + inp + " is " + sqrt);
		}
	
	}
