package support;

import support.StackInterface;
import support.StackUnderflowException;

public class ArrayStack <E> implements StackInterface <E> {
	private int size;
	private int topIndex;
	private E[] stack;
	
	public ArrayStack() {
		stack=(E[]) (new Object[10]);
		size=0;
		topIndex=-1;
	}
	@Override
	public E pop() throws StackUnderflowException {
		E result=stack[topIndex];
		stack[topIndex] = null;
		size--;
		return result;
	}

	@Override
	public E top() throws StackUnderflowException {
		return stack[topIndex];
	}

	@Override
	public void push(E element) {
	if (size==stack.length) {
		enlarge();
	}
	topIndex++;
		stack[topIndex]=element;
		size++;
	}
	public void enlarge() {
		E[] newStack=(E[]) new Object[stack.length*2];
		for (int i=0; i<stack.length; i++ ) {
			newStack[i]=stack[i];
		}
		stack=newStack;
		
	}

	@Override
	public boolean isEmpty() {
	if (size==0) {
		return true;
	}
	else {
		return false;
	}
	}
	public String toString() {
		if(size==0) {
			return "[]";
		}
		String result="[";
		for(E i: stack) {
			if (i==null) {
				result=result;
			}
			else {
		result = result+i+", ";
			}
	}
		return result.substring(0,result.length()-2) + "]";
}
}