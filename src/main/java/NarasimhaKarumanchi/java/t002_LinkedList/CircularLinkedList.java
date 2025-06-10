package main.java.NarasimhaKarumanchi.java.t002_LinkedList;

public class CircularLinkedList<T> implements CircularLinkedListService<T> {

	private ListNode<T> head;
	private int length;

	public CircularLinkedList() {
		length = 0;
	}

	@Override
	public void insertAtBegin(T data) {
		ListNode<T> newNode = new ListNode<>(data);
		if (head == null) {
			head = newNode;
			newNode.setNext(newNode);

		} else {
			ListNode<T> last = head;

			while (last.getNext() != head) {
				last = last.getNext();
			}

			last.setNext(newNode);
			newNode.setNext(head);
			head = newNode;

		}

		length++;

	}

	@Override
	public void insertAtEnd(T data) {
		ListNode<T> newNode = new ListNode<>(data);

		if (head == null) {
			head = newNode;
			newNode.setNext(newNode);
		}

		else {
			ListNode<T> last = head;
			while (last.getNext() != head) {
				last = last.getNext();
			}

			last.setNext(newNode);
			newNode.setNext(head);
		}

		length++;

	}

	@Override
	public ListNode<T> deleteFromBegin() {
		ListNode<T> last = head;
		ListNode<T> deleted = null;
		if (head == null) {
			System.out.println("Underflow!!");
			return null;
		} else if (last.getNext() == last) {
			deleted = head;
			head = null;
		} else {
			while (last.getNext() != head) {
				last = last.getNext();
			}

			deleted = head;

			last.setNext(head.getNext());
			head = head.getNext();
		}

		length--;

		return deleted;

	}

	@Override
	public ListNode<T> deleteFromEnd() {
		ListNode<T> secondLast = head;
		ListNode<T> deleted = null;

		if (head == null) {
			System.out.println("Underflow!!");
			return null;
		} else if (secondLast.getNext() == secondLast) {
			deleted = head;
			head = null;
		} else {

			while (secondLast.getNext().getNext() != head) {
				secondLast = secondLast.getNext();
			}

			deleted = secondLast.getNext();
			secondLast.setNext(head);
		}

		length--;

		return deleted;
	}

	@Override
	public int length() {

		return length;
	}

	@Override
	public boolean isEmpty() {

		return length == 0;
	}

	public void printList() {
		ListNode<T> currNode = head;
		if (head == null) {
			System.out.println("Underflow!");
			return;
		}

		while (currNode.getNext() != head) {
			System.out.print(currNode.getData() + "->");
			currNode = currNode.getNext();
		}

		System.out.print(currNode.getData());
		System.out.println();
	}

	public static void main(String[] args) {

		CircularLinkedList<Integer> cll = new CircularLinkedList<>();
		cll.insertAtBegin(3);
		cll.insertAtEnd(45);
		cll.insertAtEnd(4);
		cll.insertAtEnd(6);
		cll.insertAtEnd(23);
		cll.insertAtEnd(12);
		cll.insertAtEnd(90);
		cll.insertAtEnd(39);
		cll.insertAtEnd(34);
		cll.printList();
		
		cll.deleteFromBegin();
		cll.deleteFromEnd();

		cll.printList();

	}

}
