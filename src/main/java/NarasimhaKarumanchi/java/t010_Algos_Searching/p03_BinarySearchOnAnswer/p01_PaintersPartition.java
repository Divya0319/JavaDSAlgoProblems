package main.java.NarasimhaKarumanchi.java.t010_Algos_Searching.p03_BinarySearchOnAnswer;

public class p01_PaintersPartition {
	
	public boolean isPossible(int[] arr, int T, int X, int P) {

		int painters = 1, timeLeft = X;

		for(int i = 0; i < arr.length; i++) {
			if((arr[i] * T) > X) {
				return false;
			}

			if(arr[i] * T <= timeLeft) {
				timeLeft -= arr[i] * T;
			} else {
				painters++;
				timeLeft = X - (arr[i] * T);
			}


		}

		return (painters <= P);
		

	}
	
	public static void main(String[] args) {
		p01_PaintersPartition mainClass = new p01_PaintersPartition();
		
		int[] boards = new int[] {5, 3, 6, 1, 9};
		
		boolean result = mainClass.isPossible(boards, 2, 15, 5);
		
		if(result) {
			System.out.println("Possible to paint");
		} else {
			System.out.println("Not possible to paint");
		}
		
	}

}
