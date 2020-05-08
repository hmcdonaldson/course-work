import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import pokemon.Pokemon;
import pokemon.AttackNature;
import pokemon.DefenseNature;
import pokemon.Bulbasaur;
import pokemon.Cataperie;
import pokemon.Squirtle;
import pokemon.Charmander;
import pokemon.Charizard;

public class Pokedex{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		Scanner filesc;
		Bulbasaur newBulbasaur;
		Cataperie newCataperie;
		Squirtle newSquirtle;
		Charmander newCharmander;
		Charizard newCharizard;
		String name;
		String attack;
		String defense;
		int health;
		String bulbasaur = "Bulbasaur";
		String cataperie = "Cataperie";
		String squirtle = "Squirtle";
		String charmander = "Charmander";
		String charizard = "Charizard";
		ArrayList<Pokemon> pokemonList = new ArrayList<>();
		while(true){
			System.out.println("1. Load Team");
			System.out.println("2. Display Team");
			System.out.println("3. Exit");
			int menuChoice = sc.nextInt();
			if(menuChoice == 1){
				System.out.println("Enter file name");
				sc.nextLine();
				String fileName = sc.nextLine();
				try{
					filesc = new Scanner(new FileInputStream(fileName));
					filesc.useDelimiter(":|\n");
	
				while(filesc.hasNext()){
						name = filesc.next();
						attack = filesc.next();
						defense = filesc.next();
						health = filesc.nextInt();
						if(name.equals(bulbasaur)){
							newBulbasaur = new Bulbasaur();
							newBulbasaur.setAttack(AttackNature.valueOf(attack));
							newBulbasaur.setDefense(DefenseNature.valueOf(defense));
							try{
								newBulbasaur.setHealth(health);
							}catch(IllegalArgumentException e) {
								System.out.println("Invalid amount of health");
							}
							pokemonList.add(newBulbasaur);
				
						}else if(name.equals(cataperie)){
							newCataperie = new Cataperie();
							newCataperie.setAttack(AttackNature.valueOf(attack));
							newCataperie.setDefense(DefenseNature.valueOf(defense));
							try{
								newCataperie.setHealth(health);
							}catch(IllegalArgumentException e) {
								System.out.println("Invalid amount of health");
							}
							pokemonList.add(newCataperie);
						}else if(name.equals(squirtle)){
							newSquirtle = new Squirtle();
							newSquirtle.setAttack(AttackNature.valueOf(attack));
							newSquirtle.setDefense(DefenseNature.valueOf(defense));
							try{
								newSquirtle.setHealth(health);
							}catch(IllegalArgumentException e) {
								System.out.println("Invalid amount of health");
							}
							pokemonList.add(newSquirtle);
						}else if(name.equals(charmander)){
							newCharmander = new Charmander();
							newCharmander.setAttack(AttackNature.valueOf(attack));
							newCharmander.setDefense(DefenseNature.valueOf(defense));
							try{
								newCharmander.setHealth(health);
							}catch(IllegalArgumentException e) {
								System.out.println("Invalid amount of health");
							}
							pokemonList.add(newCharmander);

						}else if(name.equals(charizard)){
							newCharizard = new Charizard();
							newCharizard.setAttack(AttackNature.valueOf(attack));
							newCharizard.setDefense(DefenseNature.valueOf(defense));
							try{
								newCharizard.setHealth(health);
							}catch(IllegalArgumentException e) {
								System.out.println("Invalid amount of health");
							}
							pokemonList.add(newCharizard);
						}
					}
				}catch (FileNotFoundException e) {
					System.out.println("Can not open file");
				}catch(InputMismatchException e){
					System.out.println("Error parsing file ");
				}
			}
			if(menuChoice == 2){
					for (Pokemon pokemon: pokemonList){
						String pokemonType = pokemon.getClass().toString();
						pokemonType = pokemonType.replace("class pokemon.","");
						if(pokemonType.equals(bulbasaur)){
							System.out.println(Bulbasaur.getAsciiArt());
							System.out.print(Bulbasaur.name);
						}else if(pokemonType.equals(cataperie)){
							System.out.println(Cataperie.getAsciiArt());
							System.out.print(Cataperie.name);
						}else if(pokemonType.equals(squirtle)){
							System.out.println(Squirtle.getAsciiArt());
							System.out.print(Squirtle.name);
						}else if(pokemonType.equals(charmander)){
							System.out.println(Charmander.getAsciiArt());
							System.out.print(Charmander.name);
						}else if(pokemonType.equals(charizard)){
							System.out.println(Charizard.getAsciiArt());
							System.out.print(Charizard.name);
						}
						System.out.print("  Attack:" + pokemon.getAttack ());
						System.out.print(" Defense:" + pokemon.getDefense());
						System.out.println(" Health:" + pokemon.getHealth());
					}
			}
			if(menuChoice == 3){
				System.exit(0);
			}
		}
	}
}
