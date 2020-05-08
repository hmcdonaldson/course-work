public class ApartmentBuilding extends CommercialBuilding{
	boolean penthouse;

	public ApartmentBuilding(int numOfUnits, String streetAddress, boolean penthouse) throws IllFormedCommercialBuildingException {
		super(numOfUnits, streetAddress);
		this.penthouse = penthouse;
	}
}
