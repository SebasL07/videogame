package ui;
import java.util.Scanner;

import model.Videogame;

//javac -cp src src/ui/Template.java -d bin
//java -cp bin ui.Template

public class MainVideogame{
	
	/**
	 * reader is an object of the class Scanner to read the inputs
	 */
	static Scanner reader;
	/**
	 * videoController is an object of the class Videogame to execute the code
	 */
	private Videogame videoController;	

	/**
	 * MainVideogame is the constructor of the Main class
	 * pre: the object reader declared
	 * pos: reader initialized 
	 */
	public MainVideogame(){

		reader= new Scanner(System.in);
	}
	/**
	 * method main
	 * @param a
	 */
	public static void main(String[] a){
		
		MainVideogame mainObj = new MainVideogame();


		System.out.println("Por favor Ingrese la resolucion a la que desea jugar\n 1) SD\n 2) QHD\n 3) HD\n 4) FHD \n 5) QUHD \n 6) UHD\n 7) UHD 8K");
		int optionResolution = reader.nextInt();
		reader.nextLine();

		System.out.println("\nIniciando el videojuego...\n");

		mainObj.initializeApp(optionResolution);
		
		System.out.println("\nBienvenido/a, iniciando la aplicación\n");
		int option = 1;

		do{
			option = mainObj.Menu();
			mainObj.executeOperation(option);
		}while(option != 0);
		
		
	}
	/**
	 * method to initialize the object videoController
	 * pre: videoController declared
	 * @param optionResolution int, is the option of resolution thta the user chose
	 * pos: videoController initialized
	 */
	public void initializeApp(int optionResolution){

		videoController = new Videogame(optionResolution);

	}

	/**
	 * Method to print the menu and recieve the option input of the user
	 * @return option int, the option that the user choose
	 */
	public int Menu(){
		System.out.println("\nEscoja una opcion del menu por favor\n 1) Crear jugador" + "\n" + 
		" 2) Registrar enemigo a un nivel" + "\n" + 
		" 3) Registrar tesoro a un nivel" + "\n" + 
		" 4) Modificar el puntaje de un jugador" + "\n" + 
		" 5) Incrementar nivel de un jugador(wip)\n" +
		" 6) Mostrar los enemigos y tesoros de un nivel\n" +
		" 7) Contar tesoro en los niveles\n" + 
		" 8) Contar tipo de enemigo en los niveles\n" +  
		" 9) \n" +
		" 10) Enemigo que mayor puntaje otorga\n" +
		" 11)\n" +
		" 12) Mostrar el top 5 jugadores\n " +
		" 0) Salir de la aplicacion");
		int option = reader.nextInt();
		reader.nextLine();
		
		return option;
	}
	/**
	 * Method to execute the operation depending on the user's choice
	 * @param option int, user's choice
	 */
	public void executeOperation(int option){
		
		switch(option){

			case 0:
			System.out.println("Bye, gracias por usar la app");
			break;
			case 1: 
			registerPlayer();
			break;

			case 2:
			registerEnemy(); 
			break;

			case 3:
			registerTreasure();
			break;

			case 4: 
			modifyScoreInPlayer();
			break;

			case 5:
			increaseLevel();
			break;

			case 6:
			showEnemiesAndTreasures();
			break;

			case 7:
			countTreasures();
			break;

			case 8:
			countEnemies();
			break;

			case 10:
			searchEnemyGreaterScore();
			break;

			case 12:
			topFivePlayers();
			break;

			default:
			System.out.println("Por favor ingrese un valor valido");
			break;
		}
	}

	/**
	 * Method to register a player, reads the necessary information to create a player. If a nickname is already
	 * in the game the method will ask again the nickname. Then send the information to the method addPlayer from
	 * the class videogame
	 */
	public void registerPlayer(){

		System.out.println("Ingrese el nombre del jugador al que le pertence la cuenta\n");
		String name = reader.next();
		String nickname = "";

		do{
			System.out.println("\nIngrese el nickname del jugador\n");
			nickname = reader.next();
			if(videoController.playerExists(nickname)){
				System.out.println(nickname + " ya existe. Intente de nuevo");
			}
			
		}while(videoController.playerExists(nickname));
		

		System.out.println(videoController.addPlayer(nickname, name)); 

	}

	/**
	 * Method for register a treasure, asks the level where is placed the treasure. if level id number different
	 * from numbers 1 to 10, asks again. Then sends the information to the method addTreasure2Level from the class
	 * Videogame
	 */
	public void registerTreasure(){
		String id = "";	
		do{
			System.out.println("Ingrese el nivel en el que quiere ingresar. Del 1-10");
			id = reader.next();
			if(videoController.searchLevel(id) == -1){
				System.out.println("Ese no es un nivel valido. Por favor intente de nuevo");
			}
		}	while(videoController.searchLevel(id) == -1);

		System.out.println("Ingrese el nombre del tesoro");
		String name = reader.next();

		System.out.println("Ingrese URL de la imagen");
		String imageURL = reader.next();

		System.out.println("Ingrese el puntaje que da el tesoro");
		int score = reader.nextInt();

		System.out.println("Cuantos tesoros desea anadir?");
		int quantity = reader.nextInt();

		System.out.println(videoController.addTreasure2Level(id, name, imageURL, score, quantity)); 
		
	}

	/**
	* Method for register an enemy, asks the level where is placed the enemy. if level id number different
 	* from numbers 1 to 10, asks again. Then sends the information to the method addEnemy2Level from the class
	* Videogame
	*/
	public void registerEnemy(){

		String id = "";	
		do{
			System.out.println("Ingrese el nivel en el que quiere ingresar. Del 1-10");
			id = reader.next();
			if(videoController.searchLevel(id) == -1){
				System.out.println("Ese no es un nivel valido. Por favor intente de nuevo");
			}
		}	while(videoController.searchLevel(id) == -1);

		System.out.println("Ingrese el nombre del mounstro");
		String name = reader.next();

		System.out.println("Ingrese el tipo de mounstro\n 1) Ogro \n 2) Abstracto \n 3) Jefe \n 4) Mago");
		int opType = reader.nextInt();

		System.out.println("Ingrese la puntuacion que quita al jugador");
		int scoreThatRemoves = reader.nextInt();

		System.out.println("Ingrese la puntuacion que da el enemigo al ser derrotado");
		int scoreDefeated = reader.nextInt();

		System.out.println(videoController.addEnemy2Level(id, name, opType, scoreThatRemoves, scoreDefeated));
	}

	/**
	 * Method for modify the score of an existing player Reads the new score and then sends 
	 * the information to the method modifyScoreInPlayer in the class Videogame 
	 */
	public void modifyScoreInPlayer(){

		
		System.out.println("Ingrese el nickname del jugador al que le desea realizar el cambio de puntaje");
		String nickname = reader.next();

		System.out.println("Ingrese el puntaje nuevo");
		int score = reader.nextInt();

		System.out.println(videoController.modifyScoreInPlayer(nickname, score));
	}

	/**
	 * Method for increase the level of a player only if the player has the score to pass to the other level.
	 * Reads the nickname of the player that wants to pass level and then sends the information to the
	 * method increaseLevel in the class nickname
	 */
	public void increaseLevel(){

		System.out.println("Ingrese el nickname del jugador que desea subir de nivel");
		String nickname = reader.next();

		System.out.println(videoController.increaseLevel(nickname)); 
	}

	public void showEnemiesAndTreasures(){
		String id = "";	
		do{
			System.out.println("\nIngrese el nivel del cual quiere saber su informacion de enemigos y tesoros: ");
			id = reader.next();
			if(videoController.searchLevel(id) == -1){
				System.out.println("Ese no es un nivel valido. Por favor intente de nuevo");
			}
		}	while(videoController.searchLevel(id) == -1);

		System.out.println(videoController.showEnemiesAndTreasuresInLevel(id));
	}

	public void countTreasures(){

		System.out.println("Ingrese el nombre del tesoro que desea contar");
		String name = reader.next();

		System.out.println("Hay " + videoController.countTreasuresInLevels(name) + " " +name + "(s) en el juego");
	}

	public void countEnemies(){

		System.out.println("Ingrese el tipo de mounstro que desea buscar\n 1) Ogro \n 2) Abstracto \n 3) Jefe \n 4) Mago");
		int option = reader.nextInt();

		System.out.println("Hay " + videoController.countEnemiesInLevels(option) + " del tipo de mounstro seleccionado");
	}

	public void topFivePlayers(){

		System.out.println("El top 5 de jugadores es : \n"+
		videoController.top5Players());
	}

	public void searchEnemyGreaterScore(){
		
		System.out.println(videoController.searchEnemyGreaterScore());
	}

}
