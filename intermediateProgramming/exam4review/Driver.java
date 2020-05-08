import java.util.EmptyStackException;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver{
	public static void main(String[] args){
//Test Stack
		Stack testStack = new Stack();
		try{
			testStack.push(5);
			testStack.push(10);
			System.out.println(testStack.pop());
			System.out.println(testStack.pop());
		}catch(FullStackException e){
			System.out.println("Error: Stack is Full");
		}catch(EmptyStackException e){
			System.out.println("Error: Stack is Empty");
		}
		System.out.println();
//Test Matrix
		int[] a = new int[]{1,2,3,4};
		int[] b = new int[]{5,6,7,8};
		int[] c = new int[]{9,10,11,12};
		Matrix test = new Matrix(3,4);

		try{
			test.set(a,b,c);
		}catch(IllegalArgumentException e){
			System.out.println("Error");
		}


		Iterator<Integer> it = test.iterator();
		while(it.hasNext()){
			int temp = it.next();
			System.out.println(temp);
		}

		System.out.println();

		Iterator<Integer> di = test.getDiagonal();
		while(di.hasNext()){
			int temp = di.next();
			System.out.println(temp);
		}	
//Test Student
		System.out.println();
		
		Student s1 = new Student("Hunter", "McDonaldson");
		Student s2 = new Student("John", "Doe");
		System.out.println(s1.compareTo(s2));

//Test Person
		System.out.println();

		Person p1 = new Person("Hunter", "McDonaldson");
		Person p2 = new Person("John", "Doe");
		Person p3 = new Person("Hunter", "McDonaldson");
		System.out.println(p1.compareTo(p2));
		System.out.println(p1.compareTo(p3));
		System.out.println(p2.compareTo(p3));

//Test Serializable
		System.out.println();
	
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.obj"));
			Person pTest = new Person("Hunter", "McDonaldson");
			os.writeObject(pTest);
		}catch(FileNotFoundException e){
			System.out.print("Error");
		}catch(IOException e){
			System.out.print("Error");
		}
	}
}
