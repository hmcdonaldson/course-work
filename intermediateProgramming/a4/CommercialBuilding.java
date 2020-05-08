public class CommercialBuilding{
	int numOfUnits;
	String streetAddress;

	public CommercialBuilding(int numOfUnits, String streetAddress) throws IllFormedCommercialBuildingException{
		String empty = "";
		this.numOfUnits = numOfUnits;
		this.streetAddress = streetAddress;
		if(numOfUnits < 1){
			throw new IllFormedCommercialBuildingException("Invalid number of units");
		}
		if(streetAddress.equals(empty)){
			throw new IllFormedCommercialBuildingException("Missing street address");
		}	
	}
}	
