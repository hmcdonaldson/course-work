import java.util.ArrayList;

public class ArrayUtil{
	
	public static  <T> ArrayList<T> toList(T ... input){
		ArrayList<T> array = new ArrayList<T>();
		for(T obj: input){
			array.add(obj);
		}
		return array;
	}	
	public static <T> Object[] toArray(ArrayList<T> input){
		return input.toArray();
	}
	public static double min(ArrayList<? extends Number> list){
		double result = list.get(0).doubleValue();
		double temp;
		for(Number n: list){
			temp = n.doubleValue();
			if(temp < result){
				result = temp;
			}
		}
		return result;
	}
	public static void print(ArrayList<?> list){
		String s = "";
		for(Object o: list){
			s += o + " ";
		}
		System.out.println(s);
	}
}
