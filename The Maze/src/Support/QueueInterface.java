package Support;

public interface QueueInterface<T> {
	public T dequeue() throws QueueUnderflowException;
	
	public boolean isEmpty();
}
