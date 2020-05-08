import java.util.ArrayList;

public class Driver{
	public static void main(String[] args){
		Stack<String> test1 = new Stack<String>();
		test1.push("Hello");
		test1.push("World");
		System.out.println(test1.pop());
		System.out.println(test1.pop());
	
		ArrayList  test2 = ArrayUtil.<String>toList("Hello", "World", "Test");
		System.out.println(test2.toString());
		
		Object[] test3 = ArrayUtil.toArray(test2);
		for(Object obj: test3){
			System.out.println(obj);
		}
		System.out.println();

		Pair<Integer> testPair = new Pair(1,5);
		Pair<Integer> testPairSame = new Pair(1,5);
		Pair<Integer> testPairDiff = new Pair (5,1);
		System.out.println("Test getX() : " + testPair.getX());
		System.out.println("Test getY() : " + testPair.getY());
		System.out.println("Test toString() : " + testPair.toString());
		System.out.println("Test equals() : " + testPair.equals(testPairSame));
		System.out.println("Test equals() : " + testPair.equals(testPairDiff));
		System.out.println("Test hashCode() : " + testPair.hashCode());

		ArrayList testArray = ArrayUtil.toList(10, 3, 2, 5);
		double test4 = ArrayUtil.min(testArray);
		System.out.println(test4); 

		ArrayUtil.print(testArray);

		Test.<String>foo("Hello");
		Test.foo("String");	
		Test.foo(100);
	}
}
