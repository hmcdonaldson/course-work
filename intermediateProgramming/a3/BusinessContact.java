package a3;

import a2.Contact;

public class BusinessContact extends Contact{

	private String companyName;
	private String workPhone;
	private String faxNumber;

	public BusinessContact(String firstName, String lastName){
		super(firstName, lastName);
	}

	public BusinessContact(String firstName, String lastName, String companyName){
		super(firstName, lastName);
		this.companyName = companyName;
	}
	
	public BusinessContact(String firstName, String lastName, String companyName, String workPhone){
		super(firstName, lastName);
		this.companyName = companyName;
		this.workPhone = workPhone;
	}

	
	public String getCompanyName(){
		return companyName;
	}


	public String getWorkPhone(){
		return workPhone;
	}


	public String getFaxNumber(){
		return faxNumber;
	}


	public void setCompanyName(String c){
		companyName = c;
	}


	public void setWorkPhone(String w){
		workPhone = w;
	}

	public void setFaxNumber(String f){
		faxNumber = f;
	}
}		
