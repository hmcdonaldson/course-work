import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Driver2 implements Serializable{
	private static final long serialVersionVID= 1000L;
	public static Person pTest;
	public static void main(String[] args){
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("test.obj"));
			pTest = (Person) is.readObject();
		}catch(FileNotFoundException | ClassNotFoundException e){
			System.out.println("Error");
		}catch(IOException e){
			System.out.println("Error");
		}
		System.out.println(pTest.toString());
	}

}
