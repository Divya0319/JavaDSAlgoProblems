package main.java.NarasimhaKarumanchi.java._1_LinkedList;


public class _1_a_TestClass {
	
	public ListNode<Integer> rearrangeEvenOddInList(ListNode<Integer> head) {
		
		ListNode<Integer> even = new ListNode<>(-1);
		ListNode<Integer> odd = new ListNode<>(-1);
		
		ListNode<Integer> e = even, o = odd;
		
		while(head != null) {
			if(head.getData() % 2 == 0) {
				e.setNext(head);
				e = e.getNext();
			} else {
				o.setNext(head);
				o = o.getNext();
			}
			
			head = head.getNext();
		}
		
		if(even.getNext() != null) {
			e.setNext(odd.getNext());
		}
		
		if(odd.getNext() != null) {
			o.setNext(null);
		}
		
		if(even.getNext() == null) {
			return odd.getNext();
		}
		return even.getNext();
		
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
		ll1.insertAtEnd(48);
		ll1.insertAtEnd(8);

		
		System.out.println("List : " + ll1.toString());
		
		ListNode<Integer> rearrangedHead = mainClass.rearrangeEvenOddInList(ll1.getHead());
				
		System.out.println("Rearranged List: " + ll1.toString(rearrangedHead));
	
	}

}
