package main.java.NarasimhaKarumanchi.java.t011_Algos_Sorting;

public class _1_d_QuickSort {
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int partition(int[] arr, int low, int high) {
		
		// Choosing the pivot;
		int pivot = arr[high];
		
		// Index of smaller element and
		// indicates the right position of pivot found so far
		int i = (low - 1);
		for(int j = low; j <= high - 1; j++) {
			
			// if current element is smaller than pivot
			if(arr[j] < pivot) {
				
				// increment index of smaller element
				i++;
				
				swap(arr, i, j);
			}
			
		}
		swap(arr, i+1, high);
		
		return (i+1);
	}
	
	static void quicksort(int[] arr, int low, int high) {
		if(low < high) {
			int q = partition(arr, low, high);
			
			quicksort(arr, low, q-1);
			quicksort(arr, q+1, high);
		}
	}
	
	public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
	
	public static void main(String[] args) {
		int[] inp = new int[] {2, 5, 1, 7, 8, 3, 56, 19};
		
		int n = inp.length;
		quicksort(inp, 0, n-1);
		System.out.println("Sorted array: ");
		printArr(inp);
	}

}
