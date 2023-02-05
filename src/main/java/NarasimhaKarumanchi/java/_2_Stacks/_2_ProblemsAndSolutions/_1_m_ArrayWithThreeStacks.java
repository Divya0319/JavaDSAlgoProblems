package main.java.NarasimhaKarumanchi.java._2_Stacks._2_ProblemsAndSolutions;

import java.util.Arrays;
import java.util.EmptyStackException;

public class _1_m_ArrayWithThreeStacks<T> {

	private T[] dataArray;
	
	// topOne grows from left to right while pushing into 1st stack
	// topTwo grows from right to left while pushing into 2nd stack
	// baseThree is bottom element of stack 3, and topThree is top of stack 3
	// And stack 3 grows from left to right
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
		
		// Initially, we set baseThree as center index of array
		// and initially stack 3 is empty, to setting topThree as baseThree
		baseThree = size / 2;
		topThree = baseThree;
	}

	// pushing into either of 3 stacks have to be done as follows
	
	// if pushing to stack 1, and if base index of stack 3 is next to top of stack 1
	// we need to shift elements of stack 3 towards right, if there is space available after stack 3
	// otherwise, we can simply push element to stack 1 top
	
	// if pushing to stack 2, and if top index of stack 3 is next to top of stack 2
	// we need to shift elements of stack 3 towards left, if there is space available before stack 3
	// otherwise, we can simply push element to stack 2 top
	
	// if pushing to stack 3, and if top index of stack 3 is next to top of stack 2
	// we need to shift elements of stack 3 towards left, if there is space available before stack 3
	// otherwise, we can simply push element to stack 3 top
	
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
	
	// pop method takes stack id, and performs as follows:
	
	// if popping from stack 1, and top is -1, it throws exception
	// else it pops data from top of stack 1, and decrements top
	
	// if popping from stack 2, and top is size, it throws exception
	// else it pops data from top of stack 2, and increments top
	
	// if popping from stack 3, and top is equal to base AND data at base is null, it throws exception
	// else it pops data from top of stack 3, and decrements top
	// another case is if popping last element from stack 3, top becomes equal to base,
	// then, we have to make data at base as null only.
	
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
			dataArray[topTwo++] = null;
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
	
	
	// this method checks if there is space available after stack 3
	// for it to shift right
	// this is checked by seeing if top of stack 3 is less than top of stack 2
	// then shifting can be done, else no shifting allowed
	public boolean stack3RightShiftable() {
		if(topThree + 1 < topTwo) {
			return true;
		}
		
		return false;
	}
	
	// this method shifts stack 3 to one position right
	public void shiftStack3Right() {
		System.out.println("Shifting stack 3 right");
		for(int i = topThree + 1; i >= baseThree; i--) {
			dataArray[i] = dataArray[i-1];
		}
		dataArray[baseThree++] = null;
		topThree++;
	}
	
	// this method checks if there is space available before stack 3
	// for it to shift left
	// this is checked by seeing if top of stack 1 is less than base of stack 3
	// then shifting can be done, else no shifting allowed
	public boolean stack3LeftShiftable() {
		if(topOne + 1 < baseThree) {
			return true;
		}
		return false;
	}
	
	
	// this method shifts stack 3 to one position left
	public void shiftStack3Left() {
		System.out.println("Shifting stack 3 left");
		for(int i = baseThree - 1; i <= topThree - 1; i++) {
			dataArray[i] = dataArray[i+1];
		}
		
		
		// this condition is added to make sure
		// if stack 3 is empty, and any of push into stack 1 or 2
		// results in shifting of stack 3,
		// it should be made sure that baseThree should not go out of bounds
		// of array.
		// And next insertion into stack 3 will simply result in StackOverFlowError
		if(!isEmpty(3)) {
			baseThree--;
		}
		
		dataArray[topThree--] = null;
	}
	
	// method checks if stack linked with relevant stack id passed,
	// is empty or not
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
		
		_1_m_ArrayWithThreeStacks<String> awts = new _1_m_ArrayWithThreeStacks<>(10);
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
