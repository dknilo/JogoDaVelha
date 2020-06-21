package lab;

public class Maquina01 extends Computador {

	@Override //Método sobreescrito
	public String jogar(String[][] mat) {
		// TODO Auto-generated method stub
		// Nesse nível, robo irá seguir a linha sequêncialmente até achar uma coordenada nula
		for (int i=0;i<3;i++){ // Abre loop para as linhas do tabuleiro
			for (int j=0;j<3;j++){ // Abre loop para as colunas do tabuleiro
				if (mat[i][j] == null) // Valida se o campo está nulo
					return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
			}
		}
		return null;
	}

}
