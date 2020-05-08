package a2;

public  class Contact {

	private String firstName;
	private String lastName;
	private String mobilePhone;
	private String personalEmail;
	private String homePage;

	public Contact(){
		firstName = "unknown";
		lastName = "unknown";
	}

	public Contact(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public void setFirstName(String name) { firstName = name; }



	public String getFirstName() { return firstName; }



	public void setLastName(String name) { lastName = name; }



	public String getLastName() { return lastName; }



	public void setMobilePhone(String phoneNum) { mobilePhone = phoneNum; }



	public String getMobilePhone() { return mobilePhone; }



	public void setPersonalEmail(String email) { personalEmail = email; }



	public String getPersonalEmail() { return personalEmail; }



	public void  setHomePage(String url) { homePage = url; }



	public String getHomePage() { return homePage; }




}

// END OF FILE
