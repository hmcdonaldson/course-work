import java.io.Serializable;
public class Person implements Comparable<Person> , Serializable {
	String firstName;
	String lastName;
	private static final long serialVersionVID = 1000L;
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString(){
		return firstName + " " + lastName;
	}

	public int compareTo(Person p){
		return (this.firstName.length() + this.lastName.length()) - (p.firstName.length() + p.lastName.length());
	}
}
