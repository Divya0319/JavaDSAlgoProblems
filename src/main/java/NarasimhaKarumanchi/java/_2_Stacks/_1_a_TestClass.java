package main.java.NarasimhaKarumanchi.java._2_Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

import main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions._1_m_ArrayWithThreeStacks;

public class _1_a_TestClass<T> {
	
	private T[] dataArray;
	private int size, topOne, topTwo, baseThree, topThree;

	
	public _1_a_TestClass(int size) {
		if(size < 3)
			throw new IllegalStateException("Size can't be less than 3");
		
		dataArray = (T[])new Object[size];
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
		} else if(stackId == 2) {
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
		} else if(stackId == 3) {
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
			} else {
				T toPop = dataArray[topOne];
				dataArray[topOne--] = null;
				return toPop;
			}
		} else if(stackId == 2) {
			if(topTwo == size) {
				throw new EmptyStackException();
			} else {
				T toPop = dataArray[topTwo];
				dataArray[topTwo++] = null;
				return toPop;
			}
		} else if(stackId == 3) {
			if(topThree == baseThree && dataArray[topThree] == null) {
				throw new EmptyStackException();
			} else {
				T toPop = dataArray[topThree];
				dataArray[topThree--] = null;
				
				if(topThree == baseThree) {
					dataArray[topThree] = null;
				}
				return toPop;
			}
			
			
		} else 
			return null;
	}
	
	public boolean stack3RightShiftable() {
		
		if(topThree + 1 < topTwo) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean stack3LeftShiftable() {
		
		if(topOne + 1 < baseThree) {
			return true;
		}
		
		return false;
	}
	
	public void shiftStack3Left() {
		
		for(int i = baseThree - 1; i <= topThree - 1; i++) {
			dataArray[i] = dataArray[i+1];
		}
		
		if(!isEmpty(3)) {
			baseThree--;
		}
		
		dataArray[topThree--] = null;
		
	}
	
	public void shiftStack3Right() {
		for(int i = baseThree; i <= topThree + 1; i++) {
			dataArray[i] = dataArray[i-1];
		}
		
		dataArray[baseThree++] = null;
		topThree++;
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
	
	@Override
	public String toString() {
		
		return Arrays.toString(dataArray);
	}

	public static void main(String[] args) {
		String popped;

		_1_a_TestClass<String> awts = new _1_a_TestClass<>(10);
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
//		awts.pop(3);
//		System.out.println(awts.toString());
//		awts.pop(3);
//		System.out.println(awts.toString());
		
		
		
	}



}
