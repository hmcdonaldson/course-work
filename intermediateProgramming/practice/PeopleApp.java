public class PeopleApp{
	public static void main(String[] args){
		Person p1 = new Person.Builder("Hunter")
			.address("212 4th Street")
			.phone("810-2494")
			.build();
	}
}
