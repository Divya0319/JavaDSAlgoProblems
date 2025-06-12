package main.java.NarasimhaKarumanchi.java.t010_Algos_Searching.p03_BinarySearchOnAnswer;

public class p01_PaintersPartitionGoogleProblem {
	
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

	public long paintersPartition(int[] arr, int T, int P) {
		long maxEle = Integer.MIN_VALUE;
		long sumEle = 0;
        for (int j : arr) {
            maxEle = Math.max(maxEle, j);
            sumEle += j;
        }

		long l = maxEle * T;
		long r = sumEle * T;
		long ans = -1;
		while(l <= r) {
			long mid = (l + r) / 2;

			boolean res = isPossible(arr, T, (int)mid, P);

			if(res) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return ans;

	}
	
	public static void main(String[] args) {
		p01_PaintersPartitionGoogleProblem mainClass = new p01_PaintersPartitionGoogleProblem();
		
		int[] boards = new int[] {5, 3, 6, 1, 9};
		
		long result = mainClass.paintersPartition(boards, 2, 2);

		System.out.println("Minimum time taken to paint: " + result);
		
	}

}
