package structures;

import support.Node;
import support.StackInterface;
import support.StackUnderflowException;

public class LinkedStack <E> implements StackInterface <E>{
	private Node<E> head;
	private int size;
	public LinkedStack() {
		head=null;
		size=0;
	}
	@Override
	public E pop() throws StackUnderflowException {
		
		Node<E> r = head;
		head=r.getNext();
		size--;
		return r.getData();
		
	}

	@Override
	public E top() throws StackUnderflowException {
		return head.getData();
	}

	@Override
	public void push(E element) {
		Node<E> elem = new Node<E>(element);
		elem.setNext(head);
		head = elem;
		size++;
		
	}

	@Override
	public boolean isEmpty() {
		if (head==null) {
			return true;
		}
		else {
		return false;
	}
	}
	public String toString() {
			String result = "";
			Node<E> current = head;
			while (current != null) {
				result += current.getData();
				current = current.getNext();
			}

			return result;

		}
	}


