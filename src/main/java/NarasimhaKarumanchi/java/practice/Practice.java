package main.java.NarasimhaKarumanchi.java.practice;

import java.util.Arrays;

public class Practice {
	
	public int[] swapArrays(int[] a1, int[] a2) {
		int len = a1.length;
		int buf[] = new int[len];
		
		for(int i = 0; i < len; i++) {
			buf[i] = a1[i];
			a1[i] = a2[i];
			a2[i] = buf[i];
		}
		
		return buf;
	}
	
	public static void main(String[] args) {
		Practice p = new Practice();
		int[] a1 = new int[] {1, 2, 3, 4, 5, 6};
		int[] a2 = new int[] {7, 8, 9, 10, 11, 12};
		
		System.out.println("Before swapping, a1: " + Arrays.toString(a1));
		System.out.println("Before swapping, a2: " + Arrays.toString(a2));
		
		p.swapArrays(a1, a2);
		
		System.out.println("After swapping, a1: " + Arrays.toString(a1));
		System.out.println("After swapping, a2: " + Arrays.toString(a2));
	}

}
