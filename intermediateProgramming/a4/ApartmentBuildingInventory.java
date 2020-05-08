import java.util.Scanner;
import java.util.ArrayList;
 
public class ApartmentBuildingInventory {
	static ArrayList<ApartmentBuilding> apartmentList = new ArrayList<>();
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("1. Add apartment building");
		System.out.println("2. Print inventory");
		System.out.println("3. Exit");
			int menuChoice = sc.nextInt();
			if(menuChoice ==  1){
				System.out.println("Enter the number of units");
				int  numberOfUnits = sc.nextInt();
				System.out.println("Enter street address");
				sc.nextLine();
				String streetAddress = sc.nextLine();
				System.out.println("Enter true if there is a penthouse or false if there is not");
				Boolean penthouse = Boolean.parseBoolean(sc.next());
				try{
				ApartmentBuilding newApartment = new  ApartmentBuilding(numberOfUnits, streetAddress, penthouse);
				apartmentList.add(newApartment);
				} catch (IllFormedCommercialBuildingException e){
					System.out.println(e.toString());
				}
			}
			if(menuChoice == 2){
				for (ApartmentBuilding apartment : apartmentList) {
				System.out.println(apartment.numOfUnits + ", " + apartment.streetAddress + ", " + apartment.penthouse);
				}
			}
			if(menuChoice == 3){
				System.exit(0);
			}
		}
	}
}
