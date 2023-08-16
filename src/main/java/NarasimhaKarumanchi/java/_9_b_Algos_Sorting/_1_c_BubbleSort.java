package main.java.NarasimhaKarumanchi.java._9_b_Algos_Sorting;

public class _1_c_BubbleSort {
	
	public int[] bubbleSort(int[] inp) {
		int n = inp.length;
		
		int i, j, swapped;
		
		for(i = 0; i < n; i++) {
			swapped = 0;
			for(j = 0; j < n-i-1; j++) {
				if(inp[j] > inp[j+1]) {
					int temp = inp[j];
					inp[j] = inp[j+1];
					inp[j+1] = temp;
					
					swapped = 1;
				}
			}
			
			if(swapped == 0) {
				break;
			}
		}
		
		return inp;
	}
	
	public static void main(String[] args) {
		_1_c_BubbleSort mainClass = new _1_c_BubbleSort();
		int[] inp = new int[] {34, 21, 43, 12, 11, 20, 65, 54, 76};
		
		int[] sortedArr = mainClass.bubbleSort(inp);
		
		System.out.println("Sorted Array is :");
		for(int a : sortedArr) {
			System.out.print(a + " ");
		}
		
		System.out.println();
	}

}
