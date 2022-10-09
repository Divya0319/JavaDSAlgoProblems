package main.java.NarasimhaKarumanchi.java._1_LinkedList;



public class _1_a_TestClass<T> {
	
	public int josephusSolution(int n, int k) {
		
		int pos = 1;
		
		for(int i = 2; i <= n; i++) {
			pos = (pos + k-1) % i+1;
		}
		
		return pos;
		
	}
	
	public static void main(String[] args) {
		_1_a_TestClass<Character> mainClass = new _1_a_TestClass<>();
		LinkedList<Character> ll = new LinkedList<>();
		ll.insertAtBegin('a');
		ll.insertAtEnd('b');
		ll.insertAtEnd('c');
		ll.insertAtEnd('d');
		ll.insertAtEnd('e');
		ll.insertAtEnd('f');
		ll.insertAtEnd('g');
		
//		System.out.println("Original List: " + ll.toString());
		
		int n = 10, k = 9;
		
		int alive = mainClass.josephusSolution(n, k);
		
		System.out.println("Person alive is at position: " + alive);
	
	}

}
