package util6;

import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

import util6.Queue;

public class ArrayQueue implements Queue{
	int size = 4;
	int counter = 0;
	int end;	
	private Object[] queue;
	boolean ifContains = false;
	boolean ifRemove = false;

	public ArrayQueue(){
		queue = new Object[size];
		end = size - 1;
	}

	public ArrayQueue(int s){
		queue  = new Object[s];
		size = s;
		end = size - 1;
	}

	public boolean add(Object e) throws IllegalStateException, NullPointerException{
		boolean add = false;
		if(e == null){
			throw new NullPointerException();
		}
		if(counter > end){
			throw new IllegalStateException();
		}else{
			queue[counter] = e;
			counter++;
			add = true;
		}
		return add;
	}

	public boolean addAll(Object[] arr) throws IllegalStateException, NullPointerException{
		for(int i = 0; i < arr.length; i++){
			try{ 
				add(arr[i]);
			}catch(IllegalStateException | NullPointerException e){
				throw e;
			}
		}
		return true;
	}

	public boolean contains(Object o) throws NullPointerException{
		ifContains = false;
		if(o == null){
			throw new NullPointerException();
		}else{
			for(int i = 0; i < queue.length; i++){
				if (o == queue[i]){
					ifContains = true;
				}
			}
		}
 		return ifContains;
	}

	public boolean containsAll(Object[] arr) throws NullPointerException{
		int counts = 0;
		boolean ifContainsAll = false;
		for(int i = 0; i< arr.length; i++){
			try{
				contains(arr[i]);
				if(ifContains == true){
					counts++;
				}
			}catch(NullPointerException e){
				throw e;
			}
		}
		if(counts == arr.length){
			ifContainsAll = true;
		}
		return ifContainsAll;
	}

	public boolean isEmpty(){
		int j = 0;
		boolean ifIsEmpty = false;
		for(int i = 0; i < queue.length; i++){
			if(queue[i] == null || queue[i] == ""){
				j++;
			}
		}
		if(j == queue.length){
			ifIsEmpty = true;
		}
		return ifIsEmpty;
	}

	public boolean remove(Object o) throws NullPointerException{
		ifRemove = false;
		if(o == null){
			throw new NullPointerException();
		}
		for(int i = 0; i < queue.length; i++){
			if(o.equals(queue[i])){
				queue[i] = "";
				i = queue.length;
				ifRemove = true;
			}
		}
		return ifRemove;
	}
	
	public boolean removeAll(Object[] arr) throws NullPointerException{
		int counts = 0;
		boolean ifRemoveAll = false;
		for(int i = 0; i < arr.length; i++){
			try{
				remove(arr[i]);
				if(ifRemove == true){
					ifRemoveAll = true;
				}
			}catch(NullPointerException e){
				throw e;
			}
		}
		return ifRemoveAll;
	}
	
	public boolean retainAll(Object []arr) throws NullPointerException{
		int counts = 0;
		boolean ifRetainAll = false;
		for(int i = 0; i < queue.length; i++){
			counts = 0;
			for(int j = 0; j < arr.length; j++){
				if(queue[i] != arr[j]){
					counts++;
				}
				if(counts == arr.length){
					queue[i] = "";
					ifRetainAll = true;
				}
			}
		}
		return ifRetainAll;
	}
	
	public Object[] toArray(){
		Object[] newArray = new Object[size];
		for(int i = 0; i < size; i++){
			newArray[i] = queue[i];
		}
		return newArray;
	}	

	public void clear(){
		for(int i = 0; i < queue.length; i++){
			queue[i] = "";
		}
		counter = 0;
	}

	public int size(){
		return queue.length;
	}
	
	public Object element() throws NoSuchElementException{
		if(isEmpty() == true){
			throw new NoSuchElementException();
		}
		return queue[counter -1];
	}
	
	public Object peek(){
		int head = 0;
		if(counter > 0){
			head = counter -1;
		}
		Object peek = queue[head];
		if(isEmpty() == true){
			peek = null;
		}
		return peek;
	}

	public boolean offer(Object e) throws NullPointerException{
		boolean offer = false;
		if(e == null){
			throw new NullPointerException();
		}if(counter > end){
			offer = false;
		}else{
			queue[counter] = e;
			counter++;
			offer = true;
		}
		return offer;
	}

	public Object poll(){
		int head = 0;
		if(counter > 0){
			head = counter - 1;
		}
		Object poll = queue[head];
		queue[head] = "";
		counter--;
		if(isEmpty() == true){
			poll = null;
		}
		return poll;
	}
	
	public Object remove() throws NoSuchElementException{
		int head = 0;
		if(counter > 0){
			head = counter - 1;
		}
		Object remove = queue[head];
		queue[head] = "";
		counter--;
		if(isEmpty() == true){
			throw new NoSuchElementException();
		}
		return remove;
	}
	
			
}	
