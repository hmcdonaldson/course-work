package pokemon;

import java.lang.IllegalArgumentException;

public class Pokemon{
	AttackNature attack;
	DefenseNature defense;
	int health;

	public AttackNature getAttack(){return attack;}

	public DefenseNature getDefense(){return defense;}

	public int getHealth(){return health;}

	public void setAttack(AttackNature a){attack = a;}

	public void setDefense(DefenseNature d){defense = d;}

	public void setHealth(int h) throws IllegalArgumentException{
		if(h < 0 || h > 100){
			throw new IllegalArgumentException();
		}
		health = h;
	}
}
