public class Program1{
	public static void main(String[] args){
		Num n = new NumImp();
		System.out.println(n.op(4,5));
	}
	public static class NumImp implements Num{
		public int op(int a, int b){
			return a + b;
		}	
	}
}
