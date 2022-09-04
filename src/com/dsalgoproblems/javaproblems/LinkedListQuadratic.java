package com.dsalgoproblems.javaproblems;

public class LinkedListQuadratic {
	
	
	public static void main(String[] args) {
		java.util.LinkedList<Integer> k = new java.util.LinkedList<Integer>();
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
