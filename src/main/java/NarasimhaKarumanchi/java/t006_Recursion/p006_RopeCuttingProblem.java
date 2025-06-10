package main.java.NarasimhaKarumanchi.java.t006_Recursion;


public class p006_RopeCuttingProblem {

	
	static int maxNoOfPieces(int n, int a, int b, int c) {
		if(n == 0) return 0;
		
		if(n < 0) return -1;
		
		int res = maxAmong3(maxNoOfPieces(n-a, a, b, c),
							maxNoOfPieces(n-b, a, b, c),
							maxNoOfPieces(n-c, a, b, c));
		
		if(res == -1)
			return -1;
		
		return res + 1;
		
	}

	public static void main(String[] args) {
		int n = 23, a = 12, b = 11, c = 9;
		int res = maxNoOfPieces(n, a, b, c);
		if(res == -1) {
			System.out.println("Not possible to cut the rope with " + n + " length, with available cutting options");
		} else {
			System.out.println("Given rope with length " + n + " can be cut into maximum " + res + " pieces with given cutting options");
		}

	}
	
	public static int maxAmong3(int n1, int n2, int n3) {
		if(n1 >= n2 && n1 >= n3) {
			return n1;
		} else if(n2 >= n1 && n2 >= n3) {
			return n2;
		} else 
			return n3;
	}

}
