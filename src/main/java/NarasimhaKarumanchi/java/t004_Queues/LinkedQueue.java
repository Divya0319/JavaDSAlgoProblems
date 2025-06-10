package main.java.NarasimhaKarumanchi.java.t004_Queues;


public class LinkedQueue<T> implements DynamicQueueService<T>{
	private int length;
	private ListNode<T> front, rear;
	
	//Creates an empty queue
	public LinkedQueue() {
		length = 0;
		front = rear = null;
	}
	
	//Adds the specified data to rear of the queue
	@Override
	public void enQueue(T data) {
		ListNode<T> node = new ListNode<>(data);
		if(isEmpty()) 
			front = node;
		else 
			rear.setNext(node);
		rear = node;
		length++;
		
	}
	public ListNode<T> getFront() {
		return front;
	}
	
	//Removes the data at the front of the queue and returns a reference to it. Throws an Exception if 
	// queue is empty
	@Override
	public T deQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty. Underflow");
		}
		T result = front.getData();
		front = front.getNext();
		length--;
		if(isEmpty()) {
			rear = null;
		}
		return result;
	}
	
	//Returns a reference to the data at the front of the queue.
	//The data is not removed from the queue. Throws an exception if the queue is empty.
	public T first() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty.");
		}
		return front.getData();
	}
	
	//Returns true if this queue is empty and false otherwise
	@Override
	public boolean isEmpty() {
		return (length == 0);
	}
	
	@Override
	public int size() {
		return length;
	}
	
	public String toString() {
		String result = "[";
		ListNode<T> current = front;
		while(current != null) {
			result = result + current.getData();
			if(current.getNext() != null) {
				result += ", ";
			}
			current = current.getNext();
		}
		
		return result + "]";
	}

	public T getRear() {
		return rear.getData();
	}
}
