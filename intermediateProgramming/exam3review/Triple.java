public class Triple implements Tuple{
	Object[] elements = new Object[3];
	public Triple(Object a, Object b, Object c){
		elements[0] = a;
		elements[1] = b;
		elements[2] = c;
	}
	public Object getFirst(){
		return elements[0];
	}
	public Object getLast(){
		return elements[2];
	}
	public Object[] getElements(){
		return elements;
	}
	
	@Override
	public String toString(){
		return "(" + elements[0] + "," + elements[1] + "," + elements[2] + ")";
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Triple)){
			return false;
		}
		Triple temp = (Triple) obj;
		if(temp.getFirst() == elements[0] && temp.getLast() == elements[2]){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		result += 31 * result + elements[0].hashCode();
		result += 31 * result + elements[2].hashCode();
		return result;
	}
}
