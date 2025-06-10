package main.java.NarasimhaKarumanchi.java.t002_LinkedList.ProblemsAndSolutions;


public class p029_JosephusProblemSolution_Recursive {

	public int josephusSolution(int n, int k) {
		
		if(n == 1)
			return 1;
		else 
			return (josephusSolution(n-1, k) + k - 1) % n + 1;

	}

	public static void main(String[] args) {
		p029_JosephusProblemSolution_Recursive mainClass = new p029_JosephusProblemSolution_Recursive();
		
		int n = 10, k = 9;
		
		System.out.println("Last man standing in " + n + " is at position : " + mainClass.josephusSolution(n,  k));
		
	}

}
