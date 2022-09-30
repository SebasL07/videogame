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
		"2) Registrar enemigo a un nivel(wip)" + "\n" + 
		"3) Registrar tesoro a un nivel" + "\n" + 
		"4) Modificar el puntaje de un jugador(wip)" + "\n" + 
		"5) Incrementar nivel de un jugador(wip)\n" + 
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
			break;

			case 3:
			registerTreasure();
			break;

			case 4: 
			break;

			case 5:
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
		String imageURL = reader.nextLine();

		System.out.println("Ingrese el puntaje que da el tesoro");
		int score = reader.nextInt();

		System.out.println("Cuantos tesoros desea anadir?");
		int quantity = reader.nextInt();

		System.out.println(videoController.addTreasure2Level(id, name, imageURL, score, quantity)); 

		
		
	}
}