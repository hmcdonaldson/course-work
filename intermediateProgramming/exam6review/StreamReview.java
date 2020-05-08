import java.util.ArrayList;
import java.util.stream.*;

public class StreamReview{
	public static void main(String[] args){

		ArrayList<String> list1 = new ArrayList<>();
		list1.add("test");
		list1.add("string");
		list1.add("hello");
		list1.stream()
			.filter((t) -> t.length() <= 5)
			.forEach((t) -> System.out.println(t));	


		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		long count = list2.stream()
				.filter((t) -> t%2 == 1)
				.count();
		System.out.println(count);

		ArrayList<Double> list3 = new ArrayList<>();
		list3.add(3.4);
		list3.add(3.7);
		list3.add(5.5);
		Stream<Double> str = list3.stream();
		str.map((t) -> Math.round(t)).forEach((t) -> System.out.println(t));
		
		ArrayList<Students> list4 = new ArrayList<>();
		list4.add(new Students("Hunter", "McDonaldson"));
		list4.add(new Students("John" , "Doe"));
		list4.add(new Students("James", "Doe")); 
		list4.stream()
			.map((t) -> t.getLastName())
			.distinct()
			.forEach((t) -> System.out.println(t)); 

		list1.stream()
			.map((t) -> t.hashCode())
			.forEach((t) -> System.out.println(t));

		list1.stream()
			.distinct()
			.map((t) -> t.length())
			.sorted()
			.forEach((t) -> System.out.println(t));		
	}
}
