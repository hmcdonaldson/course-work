public class Driver{
	static double foo(int...a){
		double result = 0;
		int counter = 0;
		for(int i: a){
			result += i;
			counter++;
		}
		return result / counter;
	}

	static String bar(Tuple obj){
		return obj.getFirst() + " " + obj.getLast();
	}

	public static void main(String[] args){
		Pair pair = new Pair(5, 4);
		System.out.println(bar(pair));

		Triple triple = new Triple(1,2,3);
		System.out.println(bar(triple));
			
		System.out.println(foo(1,2,3,4,5));
		System.out.println(foo(10,19,1,8,12,15,5));	
	}
}

			
