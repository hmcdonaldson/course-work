class Person{
	protected String name;
	public String address;
	private String phone;
	String email;
//	private final Person spouse;
	public static int averageLifeSpan;
	public static String hello(){return "hello";}
	
	public static class Builder{
		protected String name;
		public String address = "N/A";
		private String phone = "000-000-0000";
		String email = "N/A";
		int averageLifeSpan = 70;
		public Builder(String name){
			this.name = name;
		}
		public Builder address(String address){
			this.address = address;
			return this;
		}
		public Builder phone(String phone){
			this.phone = phone;
			return this;
		}
		public Builder email(String email){
			this.email = email;
			return this;
		}
		public Builder averageLifeSpan(int a){
			this.averageLifeSpan = a;
			return this;
		}
		public Person build(){
			return new Person(this);
		}
	}
	public Person(Builder b){
		name = b.name;
		address = b.address;
		phone = b.phone;
		email = b.email;
		averageLifeSpan = b.averageLifeSpan;
	}
}
		
