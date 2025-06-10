package main.java.NarasimhaKarumanchi.java.t006_Recursion;

public class _1_l_FindnCr {
	
	public static int nCr(int n, int r) {
		if(n < r)
			return 0;
		if(r == 1)
			return n;
		if(n == 1)
			return 1;
		
		return nCr(n-1, r-1) + nCr(n-1, r);    // nCr = n-1Cr-1  +  n-1Cr
		
	}
	
	public static void main(String[] args) {
		int n = 10, r = 1;
		System.out.println("Value of nCr for given inputs is "+ nCr(n, r));
	}

}
