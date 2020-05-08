public class Pair<T> {
	T x;
	T y;
	public Pair(T firstObj, T secondObj){
		this.x = firstObj;
		this.y = secondObj;
	}
	public T getX(){
		return x;
	}
	public T getY(){
		return y;
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Pair)){
			return false;
		}
		Pair temp = (Pair) obj;
		if(temp.x.equals(x) && temp.y.equals(y)){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode(){
		int result = 17;
		result += 31 * result + x.hashCode();
		result += 31 * result + y.hashCode();
		return result;
	}
}
