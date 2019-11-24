package fase_lab;

import java.util.Scanner;

public class Fase {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please insert the max value");
		int max_value = s.nextInt();
		System.out.println("Please insert the min value");
		int min_value = s.nextInt();
		int[] participantes = new int[max_value];
		int somatoria = 0;
		double media = 0;
		int count = 0;
		
		for (int i = 0; i < max_value; i++) {
			participantes[i] = s.nextInt();
			somatoria += participantes[i];
		}
		
		media = somatoria / max_value;
		
		for (int i = 0; i < participantes.length; i++) {
			if (participantes[i] > media){
				count ++;
			}
		}
		
		String resultado = (count >= min_value) ? Integer.toString(count) : "Quatidade minima de aprovados não antigida";
		System.out.println(resultado);

	}
	

}
