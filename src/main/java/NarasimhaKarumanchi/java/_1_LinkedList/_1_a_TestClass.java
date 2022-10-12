package main.java.NarasimhaKarumanchi.java._1_LinkedList;


public class _1_a_TestClass {
	
	public ListNode<Integer> printCommonElements(ListNode<Integer> l1, ListNode<Integer> l2) {
		
		ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> head = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.getData() == l2.getData()) {
				head.setNext(new ListNode<>(l1.getData()));
				head = head.getNext();
				l1 = l1.getNext();
				l2 = l2.getNext();
			} else if(l1.getData() < l2.getData()) {
				l1 = l1.getNext();
			} else {
				l2 = l2.getNext();
			}
		}
		
		return dummy.getNext();
		
	}

	
	public static void main(String[] args) {
		_1_a_TestClass mainClass = new _1_a_TestClass();
		LinkedList<Integer> ll1 = new LinkedList<>();
		LinkedList<Integer> ll2 = new LinkedList<>();
		
		ll1.insertAtBegin(1);
		ll1.insertAtEnd(2);
		ll1.insertAtEnd(3);
		ll1.insertAtEnd(4);
		ll1.insertAtEnd(6);
		ll1.insertAtEnd(8);
		ll1.insertAtEnd(9);
		ll1.insertAtEnd(21);
		ll1.insertAtEnd(48);
		ll1.insertAtEnd(56);
		ll1.insertAtEnd(89);
		
		ll2.insertAtBegin(1);
		ll2.insertAtEnd(2);
		ll2.insertAtEnd(3);
		ll2.insertAtEnd(4);
		ll2.insertAtEnd(5);
		ll2.insertAtEnd(6);
		ll2.insertAtEnd(7);
		ll2.insertAtEnd(8);
		ll2.insertAtEnd(10);
		ll2.insertAtEnd(11);
		ll2.insertAtEnd(48);

		
		System.out.println("List 1 : " + ll1.toString());
		System.out.println("List 2 : " + ll2.toString());

		
		ListNode<Integer> commonList = mainClass.printCommonElements(ll1.getHead(), ll2.getHead());
				
		System.out.println("Common List: " + ll1.toString(commonList));
	
	}

}
