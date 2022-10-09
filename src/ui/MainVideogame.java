package ui;
import java.util.Scanner;

import model.Videogame;

//javac -cp src src/ui/Template.java -d bin
//java -cp bin ui.Template

public class MainVideogame{
	
	static Scanner reader;
	private Videogame videoController;	

	public MainVideogame(){

		reader= new Scanner(System.in);
	}
	
	public static void main(String[] a){
		
		MainVideogame mainObj = new MainVideogame();


		System.out.println("Por favor Ingrese la resolucion a la que desea jugar\n 1) Standard(SD)\n 2) QHD\n 3) HD\n 4) FHD \n 5) QUHD \n 6) UHD\n 7) UHD 8K");
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

	public void initializeApp(int optionResolution){

		videoController = new Videogame(optionResolution);
	}

	public int Menu(){
		System.out.println("\nEscoja una opcion del menu por favor\n1) Crear jugador" + "\n" + 
		"2) Registrar enemigo a un nivel" + "\n" + 
		"3) Registrar tesoro a un nivel" + "\n" + 
		"4) Modificar el puntaje de un jugador" + "\n" + 
		"5) Incrementar nivel de un jugador(wip)\n" +
		"6) Mostrar los enemigos y tesoros de un nivel\n" +
		"7) Contar tesoro en los niveles\n" +   
		"0) Salir de la aplicacion");
		int option = reader.nextInt();
		reader.nextLine();
		
		return option;
	}

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

			default:
			System.out.println("Por favor ingrese un valor valido");
			break;
		}
	}

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

	public void modifyScoreInPlayer(){

		
		System.out.println("Ingrese el nickname del jugador al que le desea realizar el cambio de puntaje");
		String nickname = reader.next();

		System.out.println("Ingrese el puntaje nuevo");
		int score = reader.nextInt();

		System.out.println(videoController.modifyScoreInPlayer(nickname, score));
	}

	public void increaseLevel(){

		System.out.println("Ingrese el nickname del jugador que desea subir de nivel");
		String nickname = reader.next();

		System.out.println(videoController.increaseLevel(nickname)); 
	}

	public void showEnemiesAndTreasures(){

		System.out.println("\nIngrese el nivel del cual quiere saber su informacion de enemigos y tesoros: ");
		String id = reader.next();

		System.out.println(videoController.showEnemiesAndTreasuresInLevel(id));
	}

	public void countTreasures(){

		System.out.println("Ingrese el nombre del tesoro que desea contar");
		String name = reader.next();

		System.out.println("Hay " + videoController.countTreasuresInLevels(name) + " " +name + "(s) en el juego");
	}
}
