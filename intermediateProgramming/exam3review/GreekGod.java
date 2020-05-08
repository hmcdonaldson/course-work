
public enum GreekGod{
	APOLLO("Leto", "Zeus"), ARES("Hera", "Zeus"), DIONYSUS("Semele", "Zeus");
	String mother;
	String father;
	GreekGod(String mother, String father){
		this.mother = mother;
		this.father = father;
	}
	public String getMother(){return mother;}
	public String getFather(){return father;}
}

