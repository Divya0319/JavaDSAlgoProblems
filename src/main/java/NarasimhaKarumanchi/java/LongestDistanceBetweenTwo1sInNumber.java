package main.java.NarasimhaKarumanchi.java;

public class LongestDistanceBetweenTwo1sInNumber {
	
	private int longestDist(int n) {
		int L = -1, R = -1;
        int distance = 0;

        while(n > 0) {
        	R++;
            if((n & 1) == 1 && (L == -1)) {
                L = R;
            } else if((n & 1) == 1 && (L != -1)) {
                distance = Math.max(distance, R - L);
                L = R;
            }


            n = n >> 1;

        }

        return distance;
	}
	
	public static void main(String[] args) {
		int n = 5;
		
		LongestDistanceBetweenTwo1sInNumber ldb2n = new LongestDistanceBetweenTwo1sInNumber();
		
		int longestDistance = ldb2n.longestDist(n);
		System.out.println("Longest distance between two adjacent 1's is : " + longestDistance);
	}

}
