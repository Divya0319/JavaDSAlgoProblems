package main.java.NarasimhaKarumanchi.java._3_Queues;

public interface FixedQueueService<T> {
	
	void enQueue(T data) throws Exception;
	
	T deQueue() throws Exception;
	
	int size();
	
	boolean isEmpty();

}
