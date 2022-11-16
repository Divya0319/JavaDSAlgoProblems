package main.java.NarasimhaKarumanchi.java._2_Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class _1_a_TestClass<T> {
	
	private T[] dataArray;
	private int size, topOne, topTwo;

	
	public _1_a_TestClass(int size) {
		if(size < 2)
			throw new IllegalStateException("Size can't be less than 2");
		
		dataArray = (T[])new Object[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}
	
	public void push(int stackId, T data) {
		
		if(topTwo == topOne + 1) {
			throw new StackOverflowError("Array is full");
		}
		
		if(stackId == 1) {
			dataArray[++topOne] = data;
		} else if(stackId == 2) {
			dataArray[--topTwo] = data;
		} else
			return;
	}
	
	public T pop(int stackId) {
		if(stackId == 1) {
			if(topOne == -1) {
				throw new EmptyStackException();
			}
			T popped = dataArray[topOne];
			dataArray[topOne--] = null;
			return popped;
		} else if(stackId == 2) {
			if(topTwo == size) {
				throw new EmptyStackException();
			}
			T popped = dataArray[topTwo];
			dataArray[topTwo++] = null;
			return popped;
		} else
			return null;
		
	}
	
	@Override
	public String toString() {
		
		return Arrays.toString(dataArray);
	}

	public static void main(String[] args) {
		_1_a_TestClass<Integer> mainClass = new _1_a_TestClass<>(16);
		
		mainClass.push(1, 8);
		mainClass.push(2, 9);
		mainClass.push(1, 0);
		mainClass.push(2, 4);
		mainClass.push(1, 17);
		mainClass.push(2, 98);
		mainClass.push(1, 90);
		mainClass.push(2, 74);
		mainClass.push(1, 83);
		mainClass.push(2, 86);
		mainClass.push(1, 89);
		mainClass.push(2, 81);
		mainClass.push(1, 85);
		
		System.out.println(mainClass.toString());
		
		
	}



}
