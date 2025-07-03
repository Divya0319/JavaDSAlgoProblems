package main.java.NarasimhaKarumanchi.java.t010_Algos_Searching.p03_BinarySearchOnAnswer;

public class p02_AggressiveCows {
	
	public boolean isPossible(int[] arr, int M, int dist) {
		int N = arr.length;

		int cows = 1, lastPos = arr[0];

		for(int i = 1; i < N; i++) {
			if(arr[i] - lastPos >= dist) {
				cows++;
				lastPos = arr[i];
				if(cows == M)
				{
					return true;
				}
			}
		}

		return false;

	}

	public long aggressiveCows(int[] arr, int M) {
		int N = arr.length;
		long l = 1, r = arr[N-1] - arr[0];
		long ans = -1;

		while(l <= r) {
			long mid = (l + r) / 2;
			boolean res = isPossible(arr, M, (int)mid);


			if(res) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;

	}
	
	public static void main(String[] args) {
		p02_AggressiveCows mainClass = new p02_AggressiveCows();
		
		int[] boards = new int[] {2, 6, 11, 14, 19, 25, 30, 39, 43};
		
		long result = mainClass.aggressiveCows(boards, 4);

		System.out.println("Maximum possible minimum distance: " + result);
		
	}

}
