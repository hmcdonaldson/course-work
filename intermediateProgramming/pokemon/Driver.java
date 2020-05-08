
import pokemon.Bulbasaur;
import pokemon.Cataperie;
import pokemon.Squirtle;
import pokemon.Charmander;
import pokemon.Charizard;

public class Driver{
	public static void main(String[] args){
		Bulbasaur b = new Bulbasaur();
		System.out.println(b.getAsciiArt());
		Cataperie c = new Cataperie();
		System.out.println(c.getAsciiArt());
		Squirtle s = new Squirtle();
		System.out.println(s.getAsciiArt());
		Charmander ch = new Charmander();
		System.out.println(ch.getAsciiArt());
		Charizard f = new Charizard();
		System.out.println(f.getAsciiArt());
	}
}
