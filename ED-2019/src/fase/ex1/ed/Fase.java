package fase.ex1.ed;

import java.util.Scanner;
import vetor.inteiros.VetorInteiros;;

public class Fase {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please insert the max value");
		int max_value = s.nextInt();
		System.out.println("Please insert the min value");
		int min_value = s.nextInt();
		
		VetorInteiros participantes = new VetorInteiros(max_value);
		VetorInteiros participantes_filtrados = new VetorInteiros(1);
		
		int somatoria = 0;
		double media = 0;
		int count = 0;
		
		for (int i = 0; i < max_value; i++) {
			participantes.adiciona(s.nextInt());
			somatoria += participantes.lastItem();
		}
		
		s.close();
		
		media = somatoria / max_value;
		
		int j = 0;
		for (int i = 0; i < participantes.tamanho(); i++) {
			if (participantes.getItemIndex(i) >= media){
				participantes_filtrados.adiciona(participantes.getItemIndex(i));
			}
		}
		
		participantes_filtrados = ordena(participantes_filtrados);
		count  = filtra_aprovados(participantes_filtrados, min_value );
		
		String resultado = (count >= min_value) ? Integer.toString(count) : "Quatidade minima de aprovados não antigida";
		System.out.println(resultado);

	}
	
	public static VetorInteiros ordena(VetorInteiros aprovados_filtrados) {
		int cont1, cont2, aux;
		for (cont1 = 0; cont1 < aprovados_filtrados.tamanho()-1; cont1++) {
			for (cont2 = 0; cont2 < aprovados_filtrados.tamanho()-2; cont2++) {
				if (aprovados_filtrados.getItemIndex(cont2) > aprovados_filtrados.getItemIndex(cont2+1)) {
					aux = aprovados_filtrados.getItemIndex(cont2+1);
					aprovados_filtrados.updateValue(aprovados_filtrados.getItemIndex(cont2), cont2+1);
					aprovados_filtrados.updateValue(aux, cont2);
				}
			}
		}
		return aprovados_filtrados;
	}
	
	public static int filtra_aprovados(VetorInteiros v, int min) {
		int count = min;
		min = v.tamanho() - (min-1);
		for (int j  = min -1; j > 0; j--) {
			if (v.getItemIndex(min-1) != v.getItemIndex(j)) {
				break;
			}
			else {
				count++;
			}
		}
		
		return count;
	}
	

}