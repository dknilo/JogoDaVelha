package lab;

//Importação de Classes
import java.util.Scanner;

public class Jogador {
	
	private Scanner cap; // Variável de captura do teclado

	// Método construtor
	public Jogador(){
		
	}
	
	// Método para solicitar jogada
	public String jogar(){
		// Solicita coordenada ao jogador
		System.out.println("Digite as coordenadas da sua jogada: ");
		// Guarda coordenada digitada
		cap = new Scanner(System.in);
		String coordenada = cap.next();
		// Carrega variável de controle
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
				coordenada.equalsIgnoreCase("22")){ // Valida se coordenada está entre as possíveis de uma matriz 3 x 3
				
				valida = 1;
				
			}else{
				// Se coordenadas forem inválidas, solicita novas ao jogador
				System.out.println("\n Coordenadas inválidas! ");
				System.out.println("Digite as coordenadas da sua jogada: ");
				// Guarda coordenada digitada
				coordenada = cap.next();
			}
		} while (valida == 0); // Enquanto variável for zero, mantém o loop
		
		return coordenada; // Retorna coordenda validada
	}

}
