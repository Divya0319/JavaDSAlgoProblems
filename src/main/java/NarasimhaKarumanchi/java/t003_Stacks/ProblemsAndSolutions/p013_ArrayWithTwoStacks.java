package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import java.util.Arrays;
import java.util.EmptyStackException;

public class p013_ArrayWithTwoStacks<T> {

	private T[] dataArray;
	private int size, topOne, topTwo;
	
	public p013_ArrayWithTwoStacks(int size) {
		if(size < 2) {
			throw new IllegalStateException("Size < 2 not allowed");
		}
		
		dataArray = (T[])new Object[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}

	/*
	 * Stack 1 is pushed from left to right
	 * and stack 2 is pushed from right to left
	 * in array
	 * 
	 * While pushing, top of 1st stack should not be adjacent to 
	 * top of 2nd stack, since this of overflow condition
	 */
	public void push(int stackId, T data) {
		if(topTwo == topOne + 1) {
			throw new StackOverflowError("Array is full");
		}
		if(stackId == 2) {
			dataArray[--topTwo] = data;
		} else if(stackId == 1) {
			dataArray[++topOne] = data;
		} else 
			return;
	}
	
	/*
	 * While popping, top of 1st stack SHOULD NOT be -1
	 * and top of 2nd stack SHOULD NOT be size, since both are invalid indices
	 * and this is underflow condition
	 */
	
	public T pop(int stackId) {
		if(stackId == 1) {
			if(topOne == -1)
				throw new EmptyStackException();
			
			T toPop = dataArray[topOne];
			dataArray[topOne--] = null;
			return toPop;
		}
		else if(stackId == 2) {
			if(topTwo == getSize()) 
				throw new EmptyStackException();
			
			T toPop = dataArray[topTwo];
			dataArray[topTwo++] = null;
			return toPop;
		}
		else return null;
	}
	
	public boolean isEmpty(int stackId) {
		if(stackId == 1) {
			return topOne == -1;
		}
		 else if(stackId == 2) {
			return topTwo == getSize();
		 }
		 else { 
			 return true;
		 }
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString(int stackId) {
		String s = "[";
		T[] newDataArray = (T[])new Object[dataArray.length];
		System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
		if(stackId == 1) {
			while(topOne != -1) {
				s = s + pop(1) + ", ";
			}
		} else {
			while(topTwo != getSize()) {
				s = s + pop(2) + ", ";
			}
		}
		
		dataArray = newDataArray;
		return s + "]";
	}
	
	public String toString() {
		return Arrays.toString(dataArray);
	}

	public static void main(String[] args) {
		
		String popped;
		
		p013_ArrayWithTwoStacks<String> awts = new p013_ArrayWithTwoStacks<>(4);
		awts.push(1, "Aman");
		System.out.println(awts.toString());
		awts.push(1, "Parkour");
		System.out.println(awts.toString());
		awts.push(2, "Norman");
		System.out.println(awts.toString());
		awts.push(1, "Gillfoyl");
		System.out.println(awts.toString());
		popped = awts.pop(1);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		awts.push(2, "Tony");
		System.out.println(awts.toString());
		
		popped = awts.pop(1);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		popped = awts.pop(1);
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
//		popped = awts.pop(1);
//		System.out.println("Popped: " + popped);
//		System.out.println(awts.toString());
		
		int n = 1;
		
		System.out.println("Contents of stack " + n + " is " + awts.toString(n));
		
			
	}

}
