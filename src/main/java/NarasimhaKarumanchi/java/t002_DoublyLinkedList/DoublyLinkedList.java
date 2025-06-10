package main.java.NarasimhaKarumanchi.java.t002_DoublyLinkedList;

public class DoublyLinkedList<T> implements DoublyLinkedListService<T> {

	private int length;
	private DLLNode<T> head;

	public DoublyLinkedList() {
		length = 0;
	}
	
	public void setHead(DLLNode<T> head) {
		this.head = head;
	}
	
	public DLLNode<T> getHead() {
		return head;
	}

	@Override
	public void insertAtBegin(T data) {
		DLLNode<T> newNode = new DLLNode<>(data);
		newNode.setNext(head);
		head = newNode;
		newNode.setPrev(null);
		if (head.getNext() != null) {
			head.getNext().setPrev(head);
		}

		length++;

	}

	@Override
	public void insertAtEnd(T data) {
		DLLNode<T> newNode = new DLLNode<>(data);
		DLLNode<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(newNode);
		newNode.setPrev(temp);
		newNode.setNext(null);

		length++;

	}

	@Override
	public void insert(T data, int position) {
		if(position < 0 || position > length) {
			return;
		}
		
		if(position == 1) {
			DLLNode<T> newNode = new DLLNode<>(data);
			newNode.setNext(head);
			head = newNode;
			newNode.setPrev(null);
			if (head.getNext() != null) {
				head.getNext().setPrev(head);
			}

			length++;
			return;
		}
		
		
		int pos = 1;
		DLLNode<T> newNode = new DLLNode<>(data);

		DLLNode<T> temp = head;
		while (pos != position - 1) {
			temp = temp.getNext();
			pos++;
		}
		
		if(position == length) {
			temp = temp.getNext();
			temp.setNext(newNode);
			newNode.setPrev(temp);
			newNode.setNext(null);
			
			length++;
			return;
		}

		newNode.setPrev(temp);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		newNode.getNext().setPrev(newNode);

		length++;

	}

	@Override
	public DLLNode<T> deleteAtBegin() {
		DLLNode<T> deleted = head;
		head = head.getNext();
		deleted.getNext().setPrev(null);
		deleted.setNext(null);
		length--;

		return deleted;
	}

	@Override
	public DLLNode<T> deleteAtEnd() {
		DLLNode<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		DLLNode<T> deleted = temp;
		temp.getPrev().setNext(null);
		temp.setPrev(null);
		length--;

		return deleted;
	}

	@Override
	public DLLNode<T> delete(int position) {
		if(position < 0 || position > length) {
			return null;
		}
		
		if(position == 1) {
			DLLNode<T> deleted = head;
			head = head.getNext();
			deleted.getNext().setPrev(null);
			deleted.setNext(null);
			length--;

			return deleted;
		}
		
		int pos = 1;
		DLLNode<T> temp = head;
		while (pos != position - 1) {
			temp = temp.getNext();
			pos++;
		}
		
		if(position == length) {
			DLLNode<T> deleted = temp.getNext();
			
			deleted.getPrev().setNext(null);
			deleted.setPrev(null);
			length--;
			return deleted;
		}

		DLLNode<T> deleted = temp.getNext();

		deleted.getNext().setPrev(temp);
		temp.getNext().setPrev(null);

		temp.setNext(temp.getNext().getNext());
		deleted.setNext(null);
		
		length--;

		return deleted;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		DLLNode<T> temp = head.getNext();
		while (temp != null) {
			result = result + ", " + temp.getData();
			temp = temp.getNext();
		}

		return result + "]";
	}

	public static void main(String[] args) {

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
//		DLLNode<Integer> head = new DLLNode<>(1);
//		DLLNode<Integer> node2 = new DLLNode<>(2);
//		DLLNode<Integer> node3 = new DLLNode<>(3);
//		DLLNode<Integer> node4 = new DLLNode<>(4);
//		DLLNode<Integer> node5 = new DLLNode<>(5);
//		DLLNode<Integer> node6 = new DLLNode<>(6);
//		DLLNode<Integer> node7 = new DLLNode<>(7);
//		DLLNode<Integer> node8 = new DLLNode<>(8);
//		
//		dll.setHead(head);
//		
//		head.setNext(node2);
//		node2.setPrev(head);
//		node2.setNext(null);
//		
//		System.out.println(dll.toString());
//		
//		node2.setNext(node3);
//		node3.setPrev(node2);
//		node3.setNext(null);
//		System.out.println(dll.toString());
//				
//		node3.setNext(node4);
//		node4.setPrev(node3);
//		node4.setNext(null);
//		System.out.println(dll.toString());
//		
//		node4.setNext(node5);
//		node5.setPrev(node4);
//		node5.setNext(null);
//		System.out.println(dll.toString());
//		
//		node5.setNext(node6);
//		node6.setPrev(node5);
//		node6.setNext(null);
//		System.out.println(dll.toString());
//		
//		node6.setNext(node7);
//		node7.setPrev(node6);
//		node7.setNext(null);
//		System.out.println(dll.toString());
//		
//		node7.setNext(node8);
//		node8.setPrev(node7);
//		node8.setNext(null);
//		System.out.println(dll.toString());
		
		
//		System.out.println("Previous node to 3 is : " + node3.getPrev().getData());
		
		dll.insertAtBegin(1);
		System.out.println(dll.toString());
		dll.insertAtEnd(2);
		System.out.println(dll.toString());
		dll.insertAtEnd(3);
		System.out.println(dll.toString());
		dll.insertAtEnd(4);
		System.out.println(dll.toString());
		dll.insertAtEnd(5);
		System.out.println(dll.toString());
		dll.insertAtEnd(6);
		System.out.println(dll.toString());
		dll.insertAtEnd(7);
		System.out.println(dll.toString());
		dll.insertAtEnd(8);
		System.out.println(dll.toString());
		
		dll.insert(45, 1);
		System.out.println(dll.toString());
		
		dll.delete(9);
		System.out.println(dll.toString());
		dll.delete(1);
		System.out.println(dll.toString());
		

	}

}
