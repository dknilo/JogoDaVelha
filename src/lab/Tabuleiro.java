package lab;

// Importação de Classes
import java.io.IOException;

public class Tabuleiro {
	// Declaração de atributos da classe
	private String mat[][] = new String[3][3];
	
	//Método construtor
	public Tabuleiro() {
	}

	// Método Getter do array
	public String[][] getMat() {
		return mat;
	}

	// Método para imprimir tabuleiro
	public void montaTabuleiro() throws InterruptedException, IOException{
		
		// Comando para limpar tela quando executado via prompt
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		// Imprime Tabuleiro
		System.out.println("\n\n");
		System.out.println("       0   1   2 ");
		System.out.println(" 0 -     |   |   ");
		System.out.println("      -----------");
		System.out.println(" 1 -     |   |   ");
		System.out.println("      -----------");
		System.out.println(" 2 -     |   |   ");
		System.out.println("\n\n");
	}
	
	// Método para validar e carregar coordenada
	public Boolean validaCoordenada(String jogada, int jogador){
		
		// Quebra coordenada e carrega valores de linha e coluna
		int num1 = Integer.parseInt(jogada.substring(0,1));
		int num2 = Integer.parseInt(jogada.substring(1));
		
		// Valida se o campo no array é nulo
		if(mat[num1][num2] == null){
			if (jogador == 1) // Quando for o jogador, marca X
				mat[num1][num2] = "X";
			else // Quando for o robo, marca O
				mat[num1][num2] = "O";
			return true;
		}
		else
			// Quando campo do array estiver preenchido, retorna falso
			return false; 
			
	}
	
	// Método para atualizar tabuleiro com as jogadas
	public void preencheTabuleiro() throws InterruptedException, IOException{

		// Criado variáveis para tratar valores nulos no array
		String pos00 = mat[0][0] != null ? mat[0][0] : " ";
		String pos01 = mat[0][1] != null ? mat[0][1] : " ";
		String pos02 = mat[0][2] != null ? mat[0][2] : " ";
		
		String pos10 = mat[1][0] != null ? mat[1][0] : " ";
		String pos11 = mat[1][1] != null ? mat[1][1] : " ";
		String pos12 = mat[1][2] != null ? mat[1][2] : " ";
		
		String pos20 = mat[2][0] != null ? mat[2][0] : " ";
		String pos21 = mat[2][1] != null ? mat[2][1] : " ";
		String pos22 = mat[2][2] != null ? mat[2][2] : " ";
		
		// Comando para limpar tela quando executado via prompt
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
		// Imprime Tabuleiro atuualizado
		System.out.println("\n\n");
		System.out.println("       0   1   2 ");
		System.out.println(" 0 -   "+pos00+" | "+pos01+" | "+pos02+" ");
		System.out.println("      -----------");
		System.out.println(" 1 -   "+pos10+" | "+pos11+" | "+pos12+" ");
		System.out.println("      -----------");
		System.out.println(" 2 -   "+pos20+" | "+pos21+" | "+pos22+" ");
		System.out.println("\n\n");

	}
	
	// Método para validar se há mais jogadas
	public Boolean proximaJogada(){
		for(int i=0;i<3;i++){ // Loop de linhas
			for(int j=0;j<3;j++){ // Loop de colunas
				if(mat[i][j] == null) // Valida se campo é nulo
					return false;
			}
		}
		return true; // Retorna verdadeiro quando não há mais jogadas
	}
	
	// Método para validar se houve vencedor
	public Boolean validaJogada(){
		
		for(int i=0;i<3;i++){ // Abre loop
			
			if (validaLinha(i)) // Chama método para validar linha
				return true;
			if (validaColuna(i)) // Chama método para validar coluna
				return true;
		}
		
		if (validaDiagonalPrincipal()) // Chama método para validar diagonal principal
			return true;
		if (validaDiagonalSecundaria()) // Chama método para validar diagonal secundária
			return true;
		
		return false; // Se não achou vencedor, retorna falso
	}
	
	// Método para validar se há vencedor nas linhas
	public Boolean validaLinha(int linha){
		
		if ((mat[linha][0] != null ? mat[linha][0] : "0") == (mat[linha][1] != null ? mat[linha][1] : "1") && 
			(mat[linha][0] != null ? mat[linha][0] : "0") == (mat[linha][2] != null ? mat[linha][2] : "2"))
			// Quando todas as marcas são iguais na linha passada por parâmetro, retorna verdadeiro
			return true;
		else
			return false;
	}
	
	// Método para validar se há vencedor nas colunas
	public Boolean validaColuna(int coluna){
		
		if ((mat[0][coluna] != null ? mat[0][coluna] : "0") == (mat[1][coluna] != null ? mat[1][coluna] : "1") && 
			(mat[0][coluna] != null ? mat[0][coluna] : "0") == (mat[2][coluna] != null ? mat[2][coluna] : "2"))
			// Quando todas as marcas são iguais na coluna passada por parâmetro, retorna verdadeiro
			return true;
		else
			return false;
	}
	
	// Método para validar se há vencedor na diagonal principal
	public Boolean validaDiagonalPrincipal(){
		
		if ((mat[0][0] != null ? mat[0][0] : "0") == (mat[1][1] != null ? mat[1][1] : "1") && 
			(mat[0][0] != null ? mat[0][0] : "0") == (mat[2][2] != null ? mat[2][2] : "2"))
			// Quando todas as marcas são iguais na diagonal principal, retorna verdadeiro
				return true;
			else
				return false;
	}
	
	// Método para validar se há vencedor na diagonal secundária
	public Boolean validaDiagonalSecundaria(){
		
		if ((mat[1][1] != null ? mat[1][1] : "1") == (mat[0][2] != null ? mat[0][2] : "0") && 
			(mat[1][1] != null ? mat[1][1] : "1") == (mat[2][0] != null ? mat[2][0] : "2"))
			// Quando todas as marcas são iguais na diagonal secundária, retorna verdadeiro
				return true;
			else
				return false;
	}
	
}
