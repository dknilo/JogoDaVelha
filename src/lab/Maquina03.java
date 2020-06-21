package lab;

// Importa��o de Classes
import java.util.Random;

public class Maquina03 extends Computador {

	@Override //M�todo sobreescrito
	public String jogar(String[][] mat) {
		// TODO Auto-generated method stub
		// Nesse n�vel, robo N�o ir� seguir uma sequ�ncia, ser� gerada uma coordenada aleat�ria
		
		// Instancia objeto
		Random random = new Random();
		int i,j;
		
		while (true){ //Abre loop at� localizar uma coordenada v�lida
			i = random.nextInt(3); // Gera n�mero alet�rio de 0(zero) a 2
			j = random.nextInt(3); // Gera n�mero alet�rio de 0(zero) a 2
			
			if (mat[i][j] == null) // Valida se o campo est� nulo
				return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
		}
	}

}
