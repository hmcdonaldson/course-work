public class CircleTest{
	public static void main(String[] args){
		try{
			Circle c1 = new Circle(1);
			Circle c2 = new Circle(0);
			c1.setRadius(2);
			c1.setRadius(0);
		}catch(IllFormedCircleException e){
			System.out.println(e.toString());
		}
	}
}
