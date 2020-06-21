package lab;

//Importa��o de Classes
import java.util.Scanner;

public class Jogador {
	
	private Scanner cap; // Vari�vel de captura do teclado

	// M�todo construtor
	public Jogador(){
		
	}
	
	// M�todo para solicitar jogada
	public String jogar(){
		// Solicita coordenada ao jogador
		System.out.println("Digite as coordenadas da sua jogada: ");
		// Guarda coordenada digitada
		cap = new Scanner(System.in);
		String coordenada = cap.next();
		// Carrega vari�vel de controle
		int valida = 0;
		
		do { // loop para validar coordenada digitada
			if (coordenada.equalsIgnoreCase("00") ||
				coordenada.equalsIgnoreCase("01") ||
				coordenada.equalsIgnoreCase("02") ||
				coordenada.equalsIgnoreCase("10") ||
				coordenada.equalsIgnoreCase("11") ||
				coordenada.equalsIgnoreCase("12") ||
				coordenada.equalsIgnoreCase("20") ||
				coordenada.equalsIgnoreCase("21") ||
				coordenada.equalsIgnoreCase("22")){ // Valida se coordenada est� entre as poss�veis de uma matriz 3 x 3
				
				valida = 1;
				
			}else{
				// Se coordenadas forem inv�lidas, solicita novas ao jogador
				System.out.println("\n Coordenadas inv�lidas! ");
				System.out.println("Digite as coordenadas da sua jogada: ");
				// Guarda coordenada digitada
				coordenada = cap.next();
			}
		} while (valida == 0); // Enquanto vari�vel for zero, mant�m o loop
		
		return coordenada; // Retorna coordenda validada
	}

}
