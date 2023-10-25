package structures;

import support.Node;

public class LinkedList<T> {

	private Node<T> head;
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void add(T element) {
		Node<T> elem = new Node<T>(element);
		if (head == null) {
			head = elem;
		} else {
			Node<T> curr = head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(elem);
		}
		size++;
	}

	public int size() {
		return size;
	}

	// gets item at index i, throws exception if i>size or i < 0
	public T get(int i) {
		if(i>= size || i<0) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> h = head;
		for(int j=0; j<i;j++) {
		h=h.getNext();
		}
		return h.getData();
	}

	// returns true if list contains s, false if not
	public boolean contains(T s) {
		Node<T> h = head;
		  while (h!=null) {
		   if(h.getData().equals(s)) {
		    return true;
		   }
		   h=h.getNext();
		  }
		  return false;
		 }

	// returns String representation of collection
	// ex. “[Chicken Sandwich, Sausage, Sauerkraut, Fish Pie]” or "[]"
	public String toString() {
		if(size()==0) {
			return "[]";
		}
		String result = "[";
		Node<T> current = head;
		int c = 0;
		while (current != null && c < size()) {
			result += current.getData()+", ";
			current = current.getNext();
			c++;
		}

		return result.substring(0,result.length()-2) + "]";

	}

	// insert given String to index i, throws exception i
	public void insert(int i, T s) {
		Node<T> elem = new Node<T>(s);
		Node<T> h = head;
		size++;
		if (i > 0) {
			for (int j = 0; j < i - 1; j++) {
				h = h.getNext();
			}
			
			elem.setNext(h.getNext());
			h.setNext(elem); 
			}
		else {
			elem.setNext(head);
			head=elem;
			}
		}
	
	
	// removes item at index i, throws exception if i>size or i < 0
	public T remove(int i) {
		if(i>= size || i<0) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> curr = head;
		int current = 0;
		if (i > 0) {
		while (current < i-2) {
			curr = curr.getNext();
			current++;
		}
		curr.setNext(curr.getNext().getNext());
		return curr.getNext().getData();
		}
		else {
			head=head.getNext();
			return curr.getData();
		}
	
	}
}
