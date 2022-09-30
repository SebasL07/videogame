package ui;
import java.util.Scanner;
import model.Videogame;

//javac -cp src src/ui/Template.java -d bin
//java -cp bin ui.Template

public class Template{
	
	static Scanner reader= new Scanner(System.in);
	
	public static void main(String[] a){
		
		System.out.println("Bienvenido/a, iniciando la aplicación\nEscoja una opcion del menu por favor");
		
	}

	public static int Menu(){
		System.out.println("1) Crear jugador" + "\n" + 
		"2) Registrar enemigo a un nivel" + "\n" + 
		"3) Registrar tesoro a un nivel" + "\n" + 
		"4) Modificar el puntaje de un jugador" + "\n" + 
		"5) Incrementar nivel de un jugador");
		int option = reader.nextInt();
		reader.nextLine();
		
		return option;
	}

	public static void executeOperation(int option){
		
		switch(option){

			case 1: 
			break;

			case 2: 
			break;

			case 3:
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
}