package Support;

public interface StackInterface<E> {
	E pop() throws StackUnderflowException;
	
	E top() throws StackUnderflowException;
	
	void push (E element);
	
	boolean isEmpty();
	
	String toString();

}
