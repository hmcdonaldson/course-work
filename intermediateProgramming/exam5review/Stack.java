import java.util.EmptyStackException;

public class Stack<T>{
	private T[] array;
	private int count = 0;
	public Stack(){
		array = (T[]) new  Object[10];
	}
	public void push(T input) throws FullStackException{
		if(count >= 10){
			throw new FullStackException();
		}
		array[count++] = input;
	}
	public T pop() throws EmptyStackException{
		if(array[0] == null){
			throw new EmptyStackException();
		}
		T temp = array[--count];
		array[count] = null;
		return temp;
	}	
}
