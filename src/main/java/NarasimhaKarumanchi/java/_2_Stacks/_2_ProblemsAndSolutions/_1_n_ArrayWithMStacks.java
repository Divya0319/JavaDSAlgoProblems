package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;
import java.util.EmptyStackException;

public class _1_n_ArrayWithMStacks<T> {

	private T[] dataArray;
	private int[] top, next;
	private int freeSpot, m;
	
	public _1_n_ArrayWithMStacks(int size, int m) {
		
		this.m = m;
		dataArray = (T[])new Object[size];
		top = new int[m];
		next = new int[size];
		
		for(int i = 0; i < m; i++) {
			top[i] = -1;
		}
		
		for(int j = 0; j < size; j++) {
			next[j] = j+1;
		}
		
		next[size-1] = -1;
		
		freeSpot = 0;
	}
	
	public void push(int stackId, T data) {
		if(stackId > m) {
			return;
		}
		
		if(freeSpot == -1)
			throw new StackOverflowError("Stack is full");
		
		// find index
		int index = freeSpot;
		
		// update freeSpot
		freeSpot = next[index];
		
		// insert element into array
		dataArray[index] = data;
		
		// update next
		next[index] = top[stackId - 1];
		
		// update top
		top[stackId-1] = index;
	}
	
	public T pop(int stackId) {
		if(stackId > m) {
			return null;
		}
		if(top[stackId - 1] == -1) {
			throw new EmptyStackException();
		}
		
		// get index of top of stackId
		int index = top[stackId-1];
		
		
		// get data
		T data = dataArray[index];
		
		
		// update top
		top[stackId - 1] = next[index];
				
		
		// update next
		next[index] = freeSpot;
		
		
		// update freeSpot
		freeSpot = index;
		
		// make space in array null
		dataArray[index] = null;
		
		return data;
	}
	
	public String toString() {
		return Arrays.toString(dataArray);
	}
	
	public static void main(String[] args) {
		
		String popped;
		
		_1_n_ArrayWithMStacks<String> awts = new _1_n_ArrayWithMStacks<>(15, 5);
		awts.push(1, "Aman");
		System.out.println(awts.toString());
		awts.push(1, "Parkour");
		System.out.println(awts.toString());
		awts.push(2, "Norman");
		System.out.println(awts.toString());
		awts.push(3, "Gillfoyl");
		System.out.println(awts.toString());
		
		popped = awts.pop(1);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		awts.push(2, "Tony");
		System.out.println(awts.toString());
		
		popped = awts.pop(1);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		popped = awts.pop(2);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		awts.push(2, "Tony");
		System.out.println(awts.toString());
		awts.push(2, "Mark");
		System.out.println(awts.toString());
		awts.push(2, "Ironman");
		System.out.println(awts.toString());
		awts.push(2, "Peter");
		System.out.println(awts.toString());
		awts.push(2, "Wanda");
		System.out.println(awts.toString());
		awts.push(3, "Vision");
		System.out.println(awts.toString());
		popped = awts.pop(2);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		awts.push(5, "Adam");
		System.out.println(awts.toString());
		popped = awts.pop(5);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		awts.push(5, "Adam");
		System.out.println(awts.toString());
		popped = awts.pop(5);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		awts.push(5, "Adam");
		System.out.println(awts.toString());
		popped = awts.pop(5);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		awts.push(5, "Adam");
		System.out.println(awts.toString());
		popped = awts.pop(5);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
			
	}

}
