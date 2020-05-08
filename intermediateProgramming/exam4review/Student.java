public class Student implements Comparable<Student>{
	String firstName;
	String lastName;
	public Student(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		return firstName + " " + lastName;
	}
	

	public int compareTo(Student s){
		int lastNameResult = this.lastName.compareToIgnoreCase(s.lastName);
		int firstNameResult = this.firstName.compareToIgnoreCase(s.firstName);
			if(lastNameResult > 0){
				return 1;
			}else if(lastNameResult < 0){
				return -1;
			}else if(lastNameResult == 0 && firstNameResult > 0){
				return 1;
			}else if(lastNameResult == 0 &&	firstNameResult < 0){
				return -1;
			}else{
				return 0;
			}
	}	
}
