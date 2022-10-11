package main.java.NarasimhaKarumanchi.java._1_LinkedList;

public class _1_a_TestClass {
	
	public ListNode<Integer> rotateListRoghtByK(ListNode<Integer> head, int k) {
		if(k < 1 || head == null || head.getNext() == null) {
			return head;
		}
		
		ListNode<Integer> temp = head;
		int n = 0;
		
		while(temp.getNext() != null) {
			temp = temp.getNext();
			n++;
		}
		
		n++;
		
		temp.setNext(head);
		
		k = k % n;
		
		temp = head;
		
		int jumps = n - k - 1;
		
		while(jumps > 0) {
			temp = temp.getNext();
			jumps--;
		}
		
		ListNode<Integer> newHead = temp.getNext();
		
		temp.setNext(null);
		
		return newHead;
	}

	
	public static void main(String[] args) {
		_1_a_TestClass mainClass = new _1_a_TestClass();
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insertAtBegin(1);
		System.out.println(ll.toString());
		ll.insertAtEnd(11);
		System.out.println(ll.toString());
		ll.insertAtEnd(3);
		System.out.println(ll.toString());
		ll.insertAtEnd(4);
		System.out.println(ll.toString());
		ll.insertAtEnd(10);
		System.out.println(ll.toString());
		ll.insertAtEnd(5);
		System.out.println(ll.toString());
		ll.insertAtEnd(15);
		System.out.println(ll.toString());
		ll.insertAtEnd(6);
		System.out.println(ll.toString());
		ll.insertAtEnd(16);
		System.out.println(ll.toString());
		ll.insertAtEnd(7);
		System.out.println(ll.toString());
		ll.insertAtEnd(8);		
		System.out.println(ll.toString());
		ll.insertAtEnd(2);
		System.out.println(ll.toString());
		ll.insertAtEnd(14);
		System.out.println(ll.toString());
		ll.insertAtEnd(13);
		System.out.println(ll.toString());
		ll.insertAtEnd(9);
		System.out.println(ll.toString());
		ll.insertAtEnd(18);
		System.out.println(ll.toString());
		ll.insertAtEnd(-17);
		System.out.println(ll.toString());
		ll.insertAtEnd(19);
		System.out.println(ll.toString());
		ll.insertAtEnd(12);
		System.out.println(ll.toString());
		
		System.out.println("Original List: " + ll.toString());
		ListNode<Integer> newHead = mainClass.rotateListRoghtByK(ll.getHead(), 5);
				
		System.out.println("Sorted List: " + ll.toString(newHead));
	
	}

}
