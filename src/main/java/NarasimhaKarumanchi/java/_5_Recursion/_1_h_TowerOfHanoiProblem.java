package main.java.NarasimhaKarumanchi.java._5_Recursion;


public class _1_h_TowerOfHanoiProblem {
	
	static int moves = 0;

	
	static void TOH(int n, char a, char b, char c) {
		
		moves++;
		
		if(n == 1) {
			System.out.println("Move 1 from " + a + " to " + c);
			
			return;
		}
		
		TOH(n-1, a, c, b);
		
		System.out.println("Move " + n + " from " + a + " to " + c);
		
		TOH(n-1, b, a, c);

		
	}

	public static void main(String[] args) {
		
		int n = 3;
		
		TOH(n, 'A', 'B', 'C');
		
		System.out.println("Number of disc movements done: " + moves);
		
	}
	
	

}
