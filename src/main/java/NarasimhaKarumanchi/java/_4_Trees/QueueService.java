package main.java.NarasimhaKarumanchi.java._4_Trees;

public interface QueueService<T> {
	
	void enQueue(T data);
	
	T deQueue() throws Exception;
	
	boolean isEmpty();

	int size();
}
