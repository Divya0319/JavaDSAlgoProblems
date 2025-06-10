package main.java.NarasimhaKarumanchi.java.t003_Stacks.ProblemsAndSolutions;

import java.util.Arrays;
import java.util.EmptyStackException;

public class p015_ArrayWithMStacks<T> {

	private T[] dataArray;
	private int[] top, next, sizeStack;
	private int freeSpot, m;
	
	public p015_ArrayWithMStacks(int size, int m) {
		
		this.m = m;
		dataArray = (T[])new Object[size];
		top = new int[m];
		next = new int[size];
		sizeStack = new int[m];
		
		
		// setting top array as -1 initially
		// as nothing there in array at beginning
		for(int i = 0; i < m; i++) {
			top[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			sizeStack[i] = 0;
		}
		
		// setting next elements as next[0] = 1, next[1] = 2, so on,
		// initially stores next free space after current index.
		for(int j = 0; j < size; j++) {
			next[j] = j+1;
		}
		
		// last element does not have more elements after that,
		// hence, it stores -1 initially
		next[size-1] = -1;
		
		
		// since array is empty initially,
		// 0th index is free, hence, setting freeSpot as 0
		freeSpot = 0;
	}
	
	
	public void push(int stackId, T data) {
		if(stackId > m) {
			return;
		}
		
		// When no freeSpot is there, we detect stack is full
		if(freeSpot == -1)
			throw new StackOverflowError("Stack is full");
		
		// FIND INDEX: 
		// have to find index at which we can push this element. 
		// freeSpot holds that index of free space.
		int index = freeSpot;
		
		// UPDATE FREESPOT: Now since freeSpot will be filled, 
		// we have to point it to new free space.
		// We can find it from next array
		freeSpot = next[index];
		
		// INSERT ELEMENT INTO ARRAY: 
		dataArray[index] = data;
		
		// UPDATE NEXT: 
		// Now, whenever anything stores in arr, we have to update next.
		// -1 is done because of 0-based indexing
		next[index] = top[stackId - 1];
		
		// Now that element is inserted, we have to UPDATE TOP.
		// top[m-1] will now become index at which we inserted.
		top[stackId-1] = index;
		
		sizeStack[stackId-1]++;
	}
	
	// Steps in pop are exactly opposite of push, 
	// bottom to top, 
	// and also LHS becomes RHS, 
	// RHS becomes LHS in this.
	public T pop(int stackId) {
		if(stackId > m) {
			return null;
		}
		if(top[stackId - 1] == -1) {
			throw new EmptyStackException();
		}
		
		// getting index of top element
		int index = top[stackId-1];
		
		
		// storing popped element
		T data = dataArray[index];
		
		
		// updating top as next element after top in stack
		top[stackId - 1] = next[index];
				
		
		// updating next as next available freeSpot
		next[index] = freeSpot;
		
		
		//  updating freeSpot as current index, 
		// as element is popped from this index
		freeSpot = index;
		
		 // making space of popped element free in dataArray
		dataArray[index] = null;
		
		sizeStack[stackId-1]--;

		
		return data;
	}
	
	public String toString() {
		return Arrays.toString(dataArray);
	}
	
	public String toString(int n) {
		String s = "[";
		if(n > m || top[n-1] == -1) 
			return "[]";
		T[] newDataArray = (T[])new Object[dataArray.length];
		System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
		
		while(top[n-1] != -1) {
			if(sizeStack[n-1] == 1) {
				s = s + pop(n);
			}
			else {
				s = s + pop(n) + ", ";
			}
			
		}
		
		dataArray = newDataArray;
		
		return s + "]";
	}
	
	public int getSizeOfStack(int n) {
		if(n > m) {
			return -1;
		}
		
		return sizeStack[n-1];
	}
	
	public static void main(String[] args) {
		
		String popped;
		
		p015_ArrayWithMStacks<String> awts = new p015_ArrayWithMStacks<>(15, 5);
		awts.push(1, "Aman");
		System.out.println("Pushed Aman to 1");
		System.out.println(awts.toString());
		
		awts.push(1, "Parkour");
		System.out.println("Pushed Parkour to 1");
		System.out.println(awts.toString());
		
		awts.push(2, "Norman");
		System.out.println("Pushed Norman to 2");
		System.out.println(awts.toString());
		
		awts.push(3, "Gillfoyl");
		System.out.println("Pushed Gillfoyl to 3");
		System.out.println(awts.toString());
		
		popped = awts.pop(1);
		System.out.println("Popped from 1");
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		awts.push(2, "Tony");
		System.out.println("Pushed Tony to 2");
		System.out.println(awts.toString());
		
		popped = awts.pop(1);
		System.out.println("Popped from 1");
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		popped = awts.pop(2);
		System.out.println("Popped from 2");
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		awts.push(2, "Steve");
		System.out.println("Pushed Steve to 2");
		System.out.println(awts.toString());
		
		awts.push(2, "Mark");
		System.out.println("Pushed Mark to 2");
		System.out.println(awts.toString());
		
		awts.push(2, "Ironman");
		System.out.println("Pushed Ironman to 2");
		System.out.println(awts.toString());
		
		awts.push(2, "Peter");
		System.out.println("Pushed Peter to 2");
		System.out.println(awts.toString());
		
		awts.push(2, "Wanda");
		System.out.println("Pushed Wanda to 2");
		System.out.println(awts.toString());
		
		awts.push(3, "Vision");
		System.out.println("Pushed Vision to 3");
		System.out.println(awts.toString());
		
		popped = awts.pop(2);
		System.out.println("Popped from 2");
		System.out.println("Popped: " + popped);
		System.out.println(awts.toString());
		
		awts.push(5, "Adam");
		System.out.println("Pushed Adam to 5");
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
		
		awts.push(4, "Yuri");
		System.out.println("Pushing Yuri to 4");
		System.out.println(awts.toString());
		
		awts.push(4, "Goro");
		System.out.println("Pushing Goro to 4");
		System.out.println(awts.toString());

		
		int n = 4;
		System.out.println("Size of stack " + n + " is " + awts.getSizeOfStack(n));
		System.out.println("Contents of stack " + n + " is " + awts.toString(n));

			
	}

}
