public class Test{
	public static <T> void foo(T arg){
		System.out.println(arg);
	}
	

	public static void foo(String arg){
		System.out.println("blah" + arg);
	}
}
