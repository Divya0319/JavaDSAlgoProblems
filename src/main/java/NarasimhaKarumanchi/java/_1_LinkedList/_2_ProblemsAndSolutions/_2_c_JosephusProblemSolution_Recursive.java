package main.java.NarasimhaKarumanchi.java._1_LinkedList._2_ProblemsAndSolutions;


public class _2_c_JosephusProblemSolution_Recursive {

	public int josephusSolution(int n, int k) {
		
		if(n == 1)
			return 1;
		else 
			return (josephusSolution(n-1, k) + k - 1) % n + 1;

	}

	public static void main(String[] args) {
		_2_c_JosephusProblemSolution_Recursive mainClass = new _2_c_JosephusProblemSolution_Recursive();
		
		int n = 10, k = 9;
		
		System.out.println("Last man standing in " + n + " is : " + mainClass.josephusSolution(n,  k));
		
	}

}
