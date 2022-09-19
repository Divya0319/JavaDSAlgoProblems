package main.java.NarasimhaKarumanchi.java;

import java.util.LinkedList;

public class LinkedListQuadratic {
	
	
	public static void main(String[] args) {
		LinkedList<Integer> k = new LinkedList<Integer>();
		int n = 100;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				k.add(k.size()/2, j);
			}
		}
		
		System.out.println(k.toString());
		System.out.println(k.size());
	}
}
