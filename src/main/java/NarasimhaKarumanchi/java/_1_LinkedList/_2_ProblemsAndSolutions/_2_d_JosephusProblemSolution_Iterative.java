package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


public class _2_d_JosephusProblemSolution_Iterative {
	
	/*
	 * Reference:  https://iq.opengenus.org/josephus-problem/
	 */

	public int josephusSolution(int n, int k) {
		
		int pos = 1;
		
		for(int i = 2; i <= n; i++) {
			pos = (pos + k - 1) % i + 1;
		}
		
		return pos;

	}

	public static void main(String[] args) {
		_2_d_JosephusProblemSolution_Iterative mainClass = new _2_d_JosephusProblemSolution_Iterative();
		
		int n = 10, k = 9;
		
		System.out.println("Last man standing in " + n + " is at position : " + mainClass.josephusSolution(n,  k));
		
	}

}
