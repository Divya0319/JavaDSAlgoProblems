package main.java.NarasimhaKarumanchi.java._2_Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class _1_a_TestClass<T>  {
	
	int largest, second_l;
	
	public void findLargestAnd2ndLargest(int[] a) {
		
		largest = Integer.MIN_VALUE;
		second_l = Integer.MIN_VALUE;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] > largest) {
				second_l = largest;
				largest = a[i];
			} else if(a[i] > second_l && a[i] != largest) {
				second_l = a[i];
				
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		_1_a_TestClass<String> mainClass = new _1_a_TestClass<>();
		
		int[] inp = new int[] {2, 3, 1, 6, 9, 14, 8, 7};
		
		System.out.println("Input: " + Arrays.toString(inp));
		
		mainClass.findLargestAnd2ndLargest(inp);
		
		System.out.println("Largest: " + mainClass.l + " Second largest: " + mainClass.second_l);
	}
}
