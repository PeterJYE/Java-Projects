package Support;

import Support.Node;
import Support.QueueUnderflowException;
import Support.UnboundedQueue;

public class LinkQueue <T> implements UnboundedQueue<T> {
	private Node<T> front;
	private Node<T> back;
	private int size;
	
	public LinkQueue() {
		front = null;
		back = null;
		size = 0;
	}
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		Node<T> curr = front;
		if(curr.getNext()==null) {
			front=null;
			back=null;
			return curr.getData();
		}
		while (curr.getNext().getNext() != null) {
			curr = curr.getNext();
		}
		T d = curr.getNext().getData();
		back=curr;
		curr.setNext(null);
		return d;
	}

	@Override
	public boolean isEmpty() {
		if(front==null) {
		return true;
		}
		return false;
	
	}


	@Override
	public void enqueue(T elem) {
		Node<T> eleme = new Node<T>(elem);
		if(front==null) {
			back =eleme;
		}
		size++;
		eleme.setNext(front);
		front=eleme;
		
		
	}
		
	}
	
	

