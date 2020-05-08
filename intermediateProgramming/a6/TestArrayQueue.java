import util6.ArrayQueue;

import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;

class TestArrayQueue{
	public static void main(String[] args){
		int testInt = 3;
		String testString = "String";
		String testNull = null;
		Object[] testAddAll = new Object[]{1, 5, "String", 10, 15};
		Object[] testContainsAll = new Object[]{1, 5, "String", 7};
		Object[] testRemovesAll1 = new Object[]{1, 7, 9};
		Object[] testRemovesAll2 = new Object[]{2, 4, 3};
		Object[] testRetainAll = new Object[]{5, 3 ,1};
		
		//Test Size
		ArrayQueue a1 = new ArrayQueue();
		System.out.println("Size test 1: " + a1.size());

		ArrayQueue a2 = new ArrayQueue(5);
		System.out.println("Size test 2: " + a2.size());

		ArrayQueue a3 = new ArrayQueue(3);
		ArrayQueue a4 = new ArrayQueue(5);
		//Test Add
		try {
			a1.add(testInt);
			a1.add(5);
			a1.add(testString);
		//Test Offer
			System.out.println("Offer test 1: " + a1.offer(20));
			System.out.println("Offer test 2: " + a1.offer(50));
		//Test Remove
			System.out.println("Remove test 1: " + a1.remove(5));
			System.out.println("Remove test 2: " + a1.remove(9));
		//Test Remove All
			a3.addAll(testRemovesAll1);
			System.out.println("Remove All test 1: " + a3.removeAll(testRemovesAll2));
		//Test Add All
			System.out.println("Add All test: " + a2.addAll(testAddAll));
		//Test Contains All
			System.out.println("Contains All test 1: " + a2.containsAll(testAddAll));
			System.out.println("Contains All test 2: " + a2.containsAll(testContainsAll));
		//Test Contains
			System.out.println("Contains test 1: " + a1.contains(3));
			System.out.println("Contains test 2: " + a1.contains(4));
		//Test Retain All
			System.out.println("Retains All test 1: " + a3.retainAll(testRemovesAll1));
			System.out.println("Retains All test 2: " + a3.retainAll(testRetainAll));
		//Test Element
			System.out.println("Element test: " + a1.element());
		//Test Remove from queue
			a4.addAll(testAddAll);
			System.out.println("Remove test 1: " + a2.remove());
			System.out.println("Remove test 2: " + a2.remove());
			//System.out.println(a1.contains(testNull));
		}catch(IllegalStateException e){
			System.out.println("Array is full");
			return;
		}catch(NullPointerException e){
			System.out.println("Element is null");
			return;
		}catch(NoSuchElementException e){
			System.out.println("Queue is empty");
			return;
		}
		//Test Peek
		System.out.println("Peek test: " + a1.peek());
		//Test toArray
		Object[] array = a2.toArray();
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		//Test Poll
		System.out.println("Poll test 1: " + a1.poll());
		System.out.println("Poll test 2: " + a1.poll());
		//Test Clear
		a2.clear();
		System.out.println("Clear test (should print false if clear was successfull): " + a2.containsAll(testAddAll));
		//Test isEmpty
		System.out.println("Empty test 1: " + a1.isEmpty());
		System.out.println("Empty test 2: " + a2.isEmpty());
	}
}
