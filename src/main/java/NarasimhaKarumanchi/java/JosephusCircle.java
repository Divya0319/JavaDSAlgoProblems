package main.java.NarasimhaKarumanchi.java;

public class JosephusCircle {
	public static void main(String[] args) {
		System.out.println(solution(10, 9));
		
	}
	
	public static int solution(int n, int k) {
		if(n == 1)
			return 0;
		int survOfNMinus1 = solution(n-1, k);
		int y = (survOfNMinus1 + k) % n;
		return y;
	}

}
