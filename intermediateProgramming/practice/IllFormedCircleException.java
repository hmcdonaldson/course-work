
public class IllFormedCircleException extends Exception{
	private String reason;
	public IllFormedCircleException(String r){
		reason = r;
	}
	@Override
	public String toString(){
		return "Ill formed circle:" + reason;
	}
}
