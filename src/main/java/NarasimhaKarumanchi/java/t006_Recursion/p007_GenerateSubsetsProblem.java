package main.java.NarasimhaKarumanchi.java.t006_Recursion;


public class p007_GenerateSubsetsProblem {

	
	static void printSubsets(String s, String curr, int i) {
		
		
		// when i becomes equal to string length, we print curr and return
		// evidently, we print all the subsets at this point
		if(i == s.length()) {
			System.out.println(curr);
			return;
		}
		
		printSubsets(s, curr, i+1);  // recursion where we don't consider character at ith position
		printSubsets(s, curr + s.charAt(i), i+1);  // recursion where we consider character at ith position
		
		
	}

	public static void main(String[] args) {
		
		printSubsets("ABC", "", 0);
	}
	
	

}
