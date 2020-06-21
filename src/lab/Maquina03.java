package lab;

// Importação de Classes
import java.util.Random;

public class Maquina03 extends Computador {

	@Override //Método sobreescrito
	public String jogar(String[][] mat) {
		// TODO Auto-generated method stub
		// Nesse nível, robo Não irá seguir uma sequência, será gerada uma coordenada aleatória
		
		// Instancia objeto
		Random random = new Random();
		int i,j;
		
		while (true){ //Abre loop até localizar uma coordenada válida
			i = random.nextInt(3); // Gera número aletório de 0(zero) a 2
			j = random.nextInt(3); // Gera número aletório de 0(zero) a 2
			
			if (mat[i][j] == null) // Valida se o campo está nulo
				return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
		}
	}

}
