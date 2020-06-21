package lab;

//Importa��o de Classes
import java.io.IOException;
import java.util.Scanner;
import lab.Tabuleiro;
import lab.Jogador;

public class Jogo {

	private static Scanner cap; // Vari�vel de captura do teclado

	//M�todo principal
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Instancia vair�veis
		cap = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		Jogador	player = new Jogador();
		Computador robo = null;
		String mat[][] = new String[3][3];
		
		//Imprime mensagem para iniciar o jogo
		System.out.println("\n JOGO DA VELHA \n");
		System.out.println("Escolha o n�vel do advers�rio (1 - 2 - 3): ");
		
		// Carrega vari�veis de controle
		int opcao = cap.nextInt();
		int valida = 0;
		String resultado = "Deu Velha!!!";
		Boolean venceu = false;
		
		do { // loop para validar escolha digitada
			if (opcao != 1 && opcao != 2 && opcao != 3){
				// Quando op��o digitada n�o for 1, 2 ou 3, solicita nova escolha
				System.out.println("\n N�vel inv�lido! ");
				System.out.println("Escolha o n�vel do advers�rio (1 - 2 - 3): ");
				// Guarda nova escolha
				opcao = cap.nextInt();
			}else{
				// Quando op��o digitada for 1, 2 ou 3, altera vari�vel de controle para 1
				valida = 1;
			}
		} while (valida == 0); // Enquanto for zero, mant�m o loop
		
		switch(opcao){ // Valida op��o selecionada para instanciar classe correta para o objeto
		case 1:
			robo = new Maquina01();
			break;
		case 2:
			robo = new Maquina02();
			break;
		case 3:
			robo = new Maquina03();
			break;
		}

		// Chama m�todo que imprime o tabuleiro
		tab.montaTabuleiro();
		
		// Carrega vari�veis de controle
		int jogador = 1;
		String jogada;
		Boolean fim = false;
		
		do{ // loop de controle do jogo
			if (jogador == 1){ // Se for a vez do jogador
				// Chama m�todo para carregar jogada
				jogada = player.jogar();
				
				while (!tab.validaCoordenada(jogada,jogador)){ // loop para validar a jogada
					System.out.println("\n Coordenada j� preenchida!!! \n");
					jogada = player.jogar();
				}
				
				// Chama m�todo para valida��o se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se jogador venceu, carrega mensagem e seta fim do loop
					resultado = "PARAB�NS!!! Voc� ganhou!";
					fim = true;
				}
				else{
					// Chama m�todo para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 2; // Altera para o pr�ximo jogador
			}
			else{ // Se for a vez do computador
				// Carrega array com as jogadas computadas at� o momento
				mat = tab.getMat(); 
				// Chama m�todo para carregar jogada do robo
				jogada = robo.jogar(mat);
				// Chama m�todo para validar e carregar a jogada
				tab.validaCoordenada(jogada,jogador);
				// Chama m�todo para valida��o se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se robo venceu, carrega mensagem e seta fim do loop
					resultado = "QUE PENA!!! Voc� perdeu!";
					fim = true;
				}
				else{
					// Chama m�todo para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 1; // Altera para o pr�ximo jogador
			}
			
			// Imprime tabuleiro preenchido at� o momento
			tab.preencheTabuleiro();
			
		}while(fim == false); // Enquanto fim n�o for setado, mant�m o loop
		
		// Imprime resultado do jogo
		System.out.println("\nFim de Jogo.");
		System.out.println("\n" + resultado);

	}

}
