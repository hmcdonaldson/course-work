public class Circle{
	private int radius;
	public Circle(int r) throws IllFormedCircleException{
		if(r <= 0){
			throw new  IllFormedCircleException("Invalid radius");
		}
		radius = r;
	}
	public void setRadius(int a) throws IllFormedCircleException{
		if(a <= 0){
			throw new IllFormedCircleException("Invalid radius");
		}
		radius = a;
	}
	public int  getRadius(){return radius;}

	@Override
	public String toString(){
		return "circle:radius =" + radius;
	}
}
