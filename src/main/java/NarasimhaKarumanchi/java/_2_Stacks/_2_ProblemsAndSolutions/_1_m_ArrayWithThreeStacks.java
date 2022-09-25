package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;
import java.util.EmptyStackException;

public class _1_m_ArrayWithThreeStacks<T> {

	private T[] dataArray;
	private int size, topOne, topTwo, baseThree, topThree;
	
	public _1_m_ArrayWithThreeStacks(int size) {
		if(size < 3) {
			throw new IllegalStateException("Size < 3 not allowed");
		}
		
		dataArray = (T[])new Object[size];
		
		for(int i = 0; i < size; i++) {
			dataArray[i] = null;
		}
		this.size = size;
		topOne = -1;
		topTwo = size;
		baseThree = size / 2;
		topThree = baseThree;
	}

	public void push(int stackId, T data) {
		if(stackId == 1) {
			if(topOne + 1 == baseThree) {
				if(stack3RightShiftable()) {
					shiftStack3Right();
					dataArray[++topOne] = data;
				} else {
					throw new StackOverflowError("Stack 1 is full");
				}
			} else {
				dataArray[++topOne] = data;
			}
		}
		
		else if(stackId == 2) {
			if(topTwo - 1 == topThree) {
				if(stack3LeftShiftable()) {
					shiftStack3Left();
					dataArray[--topTwo] = data;
				} else {
					throw new StackOverflowError("Stack 2 is full");
				}
				
			} else {
				dataArray[--topTwo] = data;
			}
		} else if(stackId == 3 ) {
			if(topThree + 1 == topTwo) {
				if(stack3LeftShiftable()) {
					shiftStack3Left();
					dataArray[++topThree] = data;
				} else {
					throw new StackOverflowError("Stack 3 is full");
				}
			} else {
				dataArray[++topThree] = data;
			}
		} else 
			return;
		
	}
	
	public T pop(int stackId) {
		if(stackId == 1) {
			if(topOne == -1) {
				throw new EmptyStackException();
			}
			T toPop = dataArray[topOne];
			dataArray[topOne--] = null;
			return toPop;
		} else if(stackId == 2) {
			if(topTwo == size) {
				throw new EmptyStackException();
			}
			T toPop = dataArray[topTwo];
			dataArray[topTwo--] = null;
			return toPop;
		} else if(stackId == 3) {
			if(topThree == baseThree && dataArray[topThree] == null) {
				throw new EmptyStackException();
			}
			T toPop = dataArray[topThree];
			dataArray[topThree--] = null;
			if(topThree == baseThree) {
				dataArray[topThree] = null;
			}
			return toPop;
		} else {
			return null;
		}
	}
	
	public T top(int stackId) {
		if(stackId == 1) {
			if(topOne == -1) {
				throw new EmptyStackException();
			}
			return dataArray[topOne];
		} else if(stackId == 2) {
			if(topTwo == size) {
				throw new EmptyStackException();
			}
			return dataArray[topTwo];
		} else if(stackId == 3) {
			if(topThree == baseThree && dataArray[topThree] == null) {
				throw new EmptyStackException();
			}
			return dataArray[topThree];
		} else {
			return null;
		}
	}
	
	public boolean stack3RightShiftable() {
		if(topThree + 1 < topTwo) {
			return true;
		}
		
		return false;
	}
	
	public void shiftStack3Right() {
		System.out.println("Shifting stack 3 right");
		for(int i = topThree + 1; i >= baseThree; i--) {
			dataArray[i] = dataArray[i-1];
		}
		dataArray[baseThree++] = null;
		topThree++;
	}
	
	public boolean stack3LeftShiftable() {
		if(topOne + 1 < baseThree) {
			return true;
		}
		return false;
	}
	
	public void shiftStack3Left() {
		System.out.println("Shifting stack 3 left");
		for(int i = baseThree - 1; i <= topThree - 1; i++) {
			dataArray[i] = dataArray[i+1];
		}
		
		if(!isEmpty(3)) {
			baseThree--;
		}
		
		dataArray[topThree--] = null;
	}
	
	public boolean isEmpty(int stackId) {
		if(stackId == 1) {
			return topOne == -1;
		} else if(stackId == 2) {
			return topTwo == size;
		} else if(stackId == 3) {
			return (topThree == baseThree && dataArray[topThree] == null);
		} else 
			return true;
	}
	
	public String toString() {
		return Arrays.toString(dataArray);
	}
	
	public static void main(String[] args) {
		
		String popped;
		
		_1_m_ArrayWithThreeStacks<String> awts = new _1_m_ArrayWithThreeStacks<>(6);
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
			
	}

}
