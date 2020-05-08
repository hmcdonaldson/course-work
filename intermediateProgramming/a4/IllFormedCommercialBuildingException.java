public class IllFormedCommercialBuildingException extends Exception{

	String reason;
	
	public IllFormedCommercialBuildingException(String reason){
		this.reason  = reason;
	}
	@Override
		public String toString(){
			return "Ill formed commercial building " + reason;
	}
} 
