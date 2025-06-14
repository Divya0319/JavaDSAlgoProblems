package main.java.NarasimhaKarumanchi.java.t004_Queues;

public interface DynamicQueueService<T> {
	
	void enQueue(T data);
	
	T deQueue() throws Exception;
	
	int size();
	
	boolean isEmpty();

}
