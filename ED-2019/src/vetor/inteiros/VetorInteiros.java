package vetor.inteiros;

public class VetorInteiros {
	private int[] numeros;
	private int tamanho;
	
	public VetorInteiros(int capacidade) {
		this.numeros = new int[capacidade];
		this.tamanho = 0;
	}
	
	public boolean adiciona(int valor) {
		this.aumentaCapacidade();

		if (this.tamanho < this.numeros.length) {
			this.numeros[this.tamanho] = valor;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	public boolean updateValue(int valor, int  index) {
		
		if (!(index >= 0 && index < tamanho)) {
			throw new IllegalArgumentException("Posição inválida");
		}

		this.numeros[index] = valor;

		return true;
	}

	private void aumentaCapacidade() {
		if (this.tamanho == this.numeros.length) {
			int[] numerosNovos = new int[this.numeros.length+1];
			for (int i = 0; i < this.numeros.length; i++) {
				numerosNovos[i] = this.numeros[i];
			}
			this.numeros = numerosNovos;
		}
	}
	
	public int lastItem() {
		return this.numeros[this.tamanho-1];
	}
	
	public int getItemIndex(int index) {
		return this.numeros[index];
	}
	
	
	public int tamanho() {
		return this.tamanho;
	}
}
