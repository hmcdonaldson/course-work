import java.lang.IllegalArgumentException;

public class PositivePair extends Pair{
	public PositivePair(Object num1, Object num2) throws IllegalArgumentException{
		if((!(num1 instanceof Integer)) || (!(num2 instanceof Integer))){
			throw new IllegalArgumentException();
		}
		int a = (int) num1;
		int b = (int) num2;
		if(a < 0 || b < 0){
			throw new IllegalArgumentException();
		}
		this.first = num1;
		this.second = num2;
	}
}
