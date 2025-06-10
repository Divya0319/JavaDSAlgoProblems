package main.java.NarasimhaKarumanchi.java.t004_Queues;

public class DynamicArrayCircularQueue<T> implements DynamicQueueService<T> {
	//Array used to implement queue
	private T[] queueRep;
	private int size, front, rear;
	
	//Length of array used to implement queue
	private int capacity = 8;   //Default queue size
	
	//Initializes the queue to use an array of default length.
	public DynamicArrayCircularQueue() {
		queueRep = (T[])new Object[capacity];
		size = 0; front = 0; rear = 0;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	//Initializes the queue to use an array of given length
	public DynamicArrayCircularQueue(int cap) {
		queueRep = (T[])new Object[cap];
		size = 0; front = 0; rear = 0;
	}
	
	//Inserts an element at the rear of the queue. This method runs in O(1) time.
	public void enQueue(T val) throws NullPointerException, IllegalStateException {
		if(size == capacity) 
			expand();
		size++;
		queueRep[rear] = val;
		rear = (rear + 1) % capacity;
			
		
	}
	
	//Removes the front element from the queue. This method runs in O(1) time.
	public T deQueue() throws NullPointerException, IllegalStateException {
		if(size == 0) {
			throw new IllegalStateException("Queue is empty. Underflow");
		} else {
			size--;
			T data = queueRep[front % capacity];
			queueRep[front] = null;
			front = (front + 1) % capacity;
			shrink();
			return data;
		}
	}
	
	//Checks whether queue is empty. This method runs in O(1) time.
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Checks whether queue is full. This method runs in O(1) time.
	public boolean isFull() {
		return size == capacity;
	}
	
	//Returns the size of the queue
	public int size() {
		return size;
	}
	
	//Increases the queue size by double
	public void expand() {
		int length = size();
		T[] newQueue = (T[])new Object[length << 1];  //<<1 means multiplying by 2
		
		//copy items
		for(int i = 0; i < length ; i++) 
			newQueue[i] = queueRep[(front + i) % capacity];
		queueRep = newQueue;
		front = 0; 
		rear = length;
		capacity  = capacity << 1;
		
		System.out.println("Queue expanded");
	}
	
	//dynamic array operation: shrinks to 1/2 if more than 3/4 empty
	private void shrink() {
		int length = size();
		if(length <= capacity >> 2) {
			capacity = capacity >> 1;
			T[] newQueue = (T[])new Object[capacity];
			System.arraycopy(queueRep, front, newQueue, 0, length);
			queueRep = newQueue;
			System.out.println("Queue shrinked");
			front = 0;
			rear = length;
		}
		
	}
	
	//Returns a string representation of the queue as list of elements, with 
	// the front element at the end: [..., prev, rear]. This method runs in O(n) time.
	public String toString() {
		String result = "[";
		for(int i = 0; i < capacity; i++) {
			result += queueRep[i];
			if(i < capacity - 1) {
				result += ", ";
			}
			
		}
		
		result += "]";
		return result;		
	}

	public static void main(String[] args) {
		
		DynamicArrayCircularQueue<Integer> lq = new DynamicArrayCircularQueue<>();
		lq.enQueue(1);
		lq.enQueue(2);
		lq.enQueue(3);
		lq.enQueue(4);
		lq.enQueue(5);
		lq.enQueue(6);
		lq.enQueue(7);
		lq.enQueue(8);
		System.out.println(lq.toString());
		System.out.println("Capacity:" + lq.getCapacity());
		lq.deQueue();
		System.out.println(lq.toString());
		lq.deQueue();
		System.out.println(lq.toString());
		lq.deQueue();
		System.out.println(lq.toString());
		lq.deQueue();
		System.out.println(lq.toString());
		lq.deQueue();
		System.out.println(lq.toString());
		lq.deQueue();
		System.out.println(lq.toString());
		System.out.println("Capacity:" + lq.getCapacity());
		lq.enQueue(55);
		System.out.println(lq.toString());
		lq.enQueue(66);
		System.out.println(lq.toString());
		lq.enQueue(77);
		System.out.println(lq.toString());
		lq.enQueue(88);
		System.out.println(lq.toString());
		lq.enQueue(15);
		System.out.println(lq.toString());
		lq.enQueue(16);
		System.out.println(lq.toString());
		lq.enQueue(17);
		System.out.println(lq.toString());
		lq.enQueue(18);
		System.out.println(lq.toString());
		lq.enQueue(19);
		System.out.println(lq.toString());
		lq.enQueue(20);
		System.out.println(lq.toString());
		lq.enQueue(21);
		System.out.println(lq.toString());
		lq.enQueue(22);
		System.out.println(lq.toString());
		lq.enQueue(23);
		System.out.println(lq.toString());
		System.out.println();
		
	}
}
