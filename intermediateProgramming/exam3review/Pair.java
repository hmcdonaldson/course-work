public class Pair implements Tuple{
	Object first;
	Object second;
	public Pair(){}
	public Pair(Object a, Object b){
		this.first = a;
		this.second = b;
	}
	public Object getFirst(){
		return first;
	}
	public Object getLast(){
		return second;
	}
	public Object[] getElements(){
		Object[] pair = new Object[]{first, second};
		return pair;
	}

	@Override
	public String toString(){
		return "(" + first + "," + second + ")";
	}

	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Pair)){
			return false;
		}
		Pair temp = (Pair) obj;
		if(temp.first == first && temp.second == second){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result += 31 * result + first.hashCode();
		result += 31 * result + second.hashCode();
		return result;
	}
}
