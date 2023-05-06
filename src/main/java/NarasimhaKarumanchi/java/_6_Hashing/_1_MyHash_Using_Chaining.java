package main.java.NarasimhaKarumanchi.java._6_Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class _1_MyHash_Using_Chaining {
	
	int BUCKET;
	ArrayList<LinkedList<Integer>> table;
	
	public _1_MyHash_Using_Chaining(int b) {
		BUCKET = b;
		table = new ArrayList<>();
		
		for(int i = 0; i < b; i++) {
			table.add(new LinkedList<Integer>());
		}
	}
	
	void insert(int key) {
		int i = key % BUCKET;
		table.get(i).add(key);
	}
	
	boolean search(int key) {
		int i = key % BUCKET;
		return table.get(i).contains(key);	
	}
	
	void remove(int key) {
		int i = key % BUCKET;
		table.get(i).remove((Integer)i);
	}

}
