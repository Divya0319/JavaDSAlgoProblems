package main.java.NarasimhaKarumanchi.java._1_LinkedList;

public class _1_a_TestClass {
	
	public ListNode<Integer> partitionListBasedOnK(ListNode<Integer> head, int k) {
		ListNode<Integer> left = new ListNode<>(0);
		ListNode<Integer> right = new ListNode<>(0);
		
		ListNode<Integer> l = left, r = right;
		
		while(head != null) {
			if(head.getData() < k) {
				l.setNext(head);
				l = l.getNext();
			} else {
				r.setNext(head);
				r = r.getNext();
			}
			
			head = head.getNext();
		}

		l.setNext(right.getNext());
		r.setNext(null);
		
		return left.getNext();
		
	}

	
	public static void main(String[] args) {
		_1_a_TestClass mainClass = new _1_a_TestClass();
		LinkedList<Integer> ll1 = new LinkedList<>();
		
		ll1.insertAtBegin(1);
		ll1.insertAtEnd(3);
		ll1.insertAtEnd(6);
		ll1.insertAtEnd(2);
		ll1.insertAtEnd(56);
		ll1.insertAtEnd(48);
		ll1.insertAtEnd(21);
		ll1.insertAtEnd(4);
		ll1.insertAtEnd(9);
		ll1.insertAtEnd(89);
		ll1.insertAtEnd(8);

		
		System.out.println("List : " + ll1.toString());
		
		int k = 19;

		ListNode<Integer> sumList = mainClass.partitionListBasedOnK(ll1.getHead(), k);
				
		System.out.println("Partition List based on " + k + " is " +  ll1.toString(sumList));
	
	}

}
