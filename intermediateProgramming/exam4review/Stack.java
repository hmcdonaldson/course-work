import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;

public class Stack implements StackInterface, Iterable<Object>{
	private Object[] stack;
	private int next = 0;
	
	public Stack(){
		stack = new Object[10];
	}
	
	public void push(Object obj) throws FullStackException{
		if(next == 10) {
			throw new FullStackException();
		}
		stack[next++] = obj;
	}
	
	public Object pop(){
		if (next == 0) {
			throw new EmptyStackException();
		}
		return stack[--next];
	}

	public Iterator<Object> iterator(){
		return new StackIterator();
	}

	public class StackIterator implements Iterator<Object>{
		private int nextReturn = next;
		public boolean hasNext(){
			if(nextReturn > 0){
				return true;
			}
			return false;
		}
		public Object next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return stack[--nextReturn];
		}
	}

}
