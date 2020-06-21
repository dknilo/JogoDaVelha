package lab;

//Importação de Classes
import java.io.IOException;
import java.util.Scanner;
import lab.Tabuleiro;
import lab.Jogador;

public class Jogo {

	private static Scanner cap; // Variável de captura do teclado

	//Método principal
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Instancia vairáveis
		cap = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		Jogador	player = new Jogador();
		Computador robo = null;
		String mat[][] = new String[3][3];
		
		//Imprime mensagem para iniciar o jogo
		System.out.println("\n JOGO DA VELHA \n");
		System.out.println("Escolha o nível do adversário (1 - 2 - 3): ");
		
		// Carrega variáveis de controle
		int opcao = cap.nextInt();
		int valida = 0;
		String resultado = "Deu Velha!!!";
		Boolean venceu = false;
		
		do { // loop para validar escolha digitada
			if (opcao != 1 && opcao != 2 && opcao != 3){
				// Quando opção digitada não for 1, 2 ou 3, solicita nova escolha
				System.out.println("\n Nível inválido! ");
				System.out.println("Escolha o nível do adversário (1 - 2 - 3): ");
				// Guarda nova escolha
				opcao = cap.nextInt();
			}else{
				// Quando opção digitada for 1, 2 ou 3, altera variável de controle para 1
				valida = 1;
			}
		} while (valida == 0); // Enquanto for zero, mantém o loop
		
		switch(opcao){ // Valida opção selecionada para instanciar classe correta para o objeto
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

		// Chama método que imprime o tabuleiro
		tab.montaTabuleiro();
		
		// Carrega variáveis de controle
		int jogador = 1;
		String jogada;
		Boolean fim = false;
		
		do{ // loop de controle do jogo
			if (jogador == 1){ // Se for a vez do jogador
				// Chama método para carregar jogada
				jogada = player.jogar();
				
				while (!tab.validaCoordenada(jogada,jogador)){ // loop para validar a jogada
					System.out.println("\n Coordenada já preenchida!!! \n");
					jogada = player.jogar();
				}
				
				// Chama método para validação se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se jogador venceu, carrega mensagem e seta fim do loop
					resultado = "PARABÉNS!!! Você ganhou!";
					fim = true;
				}
				else{
					// Chama método para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 2; // Altera para o próximo jogador
			}
			else{ // Se for a vez do computador
				// Carrega array com as jogadas computadas até o momento
				mat = tab.getMat(); 
				// Chama método para carregar jogada do robo
				jogada = robo.jogar(mat);
				// Chama método para validar e carregar a jogada
				tab.validaCoordenada(jogada,jogador);
				// Chama método para validação se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se robo venceu, carrega mensagem e seta fim do loop
					resultado = "QUE PENA!!! Você perdeu!";
					fim = true;
				}
				else{
					// Chama método para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 1; // Altera para o próximo jogador
			}
			
			// Imprime tabuleiro preenchido até o momento
			tab.preencheTabuleiro();
			
		}while(fim == false); // Enquanto fim não for setado, mantém o loop
		
		// Imprime resultado do jogo
		System.out.println("\nFim de Jogo.");
		System.out.println("\n" + resultado);

	}

}
