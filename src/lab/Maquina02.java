package lab;

public class Maquina02 extends Computador {

	@Override //M�todo sobreescrito
	public String jogar(String[][] mat) {
		// TODO Auto-generated method stub
		// Nesse n�vel, robo ir� seguir a coluna sequ�ncialmente at� achar uma coordenada nula
		for (int i=0;i<3;i++){ // Abre loop para as colunas do tabuleiro
			for (int j=0;j<3;j++){ // Abre loop para as linhas do tabuleiro
				if (mat[j][i] == null) // Valida se o campo est� nulo
					return (Integer.toString(j)) + (Integer.toString(i)); // retorna coordenada
			}
		}
		return null;
	}

}
