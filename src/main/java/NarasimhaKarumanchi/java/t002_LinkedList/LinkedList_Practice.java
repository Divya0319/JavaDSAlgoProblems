package main.java.NarasimhaKarumanchi.java.t002_LinkedList;

public class LinkedList_Practice<T> implements LinkedListService_Practice<T> {
	
	private int length = 0;
	private ListNode_Practice<T> head;
	
	public LinkedList_Practice() {
		length = 0;
	}
	
	
	public synchronized ListNode_Practice<T> getHead() {
		return head;
	}



	public static void main(String[] args) {
		
	}
	@Override
	public void insertAtBegin(T data) {
		ListNode_Practice<T> newNode = new ListNode_Practice<>(data);
		newNode.setNext(head);
		head = newNode;
		
		length++;
		
	}
	@Override
	public void insertAtEnd(T data) {
		ListNode_Practice<T> newNode = new ListNode_Practice<>(data);
		ListNode_Practice<T> temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		
		temp.setNext(newNode);
		newNode.setNext(null);
		
		length++;
		
	}
	@Override
	public void insert(T data, int position) {
		int pos = 1;
		ListNode_Practice<T> newNode = new ListNode_Practice<>(data);
		ListNode_Practice<T> temp = head;
		while(pos != position - 1) {
			temp = temp.getNext();
		}
		
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		
		length++;
		
	}
	@Override
	public ListNode_Practice<T> deleteAtBegin() {
		ListNode_Practice<T> deleted = head;
		head = head.getNext();
		
		length--;
		return deleted;
	}
	@Override
	public ListNode_Practice<T> deleteAtEnd() {
		ListNode_Practice<T> temp = head;
		while(temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		
		ListNode_Practice<T> deleted = temp.getNext();
		temp.setNext(null);
		length--;
		return deleted;
	}
	@Override
	public ListNode_Practice<T> delete(int position) {
		int pos = 1;
		ListNode_Practice<T> temp = head;
		while(pos != position - 1) {
			temp = temp.getNext();
		}
		ListNode_Practice<T> deleted = temp.getNext();
		temp.setNext(temp.getNext().getNext());
		
		length--;
		return deleted;
	}
	
	public int findPositionOfNodeWhenDataGiven(int data) {
		ListNode_Practice<Integer> temp = (ListNode_Practice<Integer>) head;
		int pos = 0;
		
		while(temp != null) {
			if(temp.getData() == data) {
				return pos;
			}
			
			pos++;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}
	
	@Override
	public int getLength() {
		return length;
	}
	@Override
	public boolean isEmpty() {
		return length == 0;
	}
    
}



