package main.java.NarasimhaKarumanchi.java._3_Queues;

public interface QueueService<T> {
	
	void enQueue(T data);
	
	T deQueue() throws Exception;
	
	int size();
	
	boolean isEmpty();

}
