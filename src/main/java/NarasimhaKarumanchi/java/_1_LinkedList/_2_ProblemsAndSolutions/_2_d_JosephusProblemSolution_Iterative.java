package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


public class _2_d_JosephusProblemSolution_Iterative {

	public int josephusSolution(int n, int k) {
		
		int sum = 0;
		
		for(int i = 2; i <= n; i++) {
			sum = (sum + k) % i;
		}
		
		return sum + 1;

	}

	public static void main(String[] args) {
		_2_d_JosephusProblemSolution_Iterative mainClass = new _2_d_JosephusProblemSolution_Iterative();
		
		int n = 10, k = 9;
		
		System.out.println("Last man standing in " + n + " is : " + mainClass.josephusSolution(n,  k));
		
	}

}
