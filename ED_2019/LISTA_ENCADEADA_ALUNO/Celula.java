package ed5;

public class Celula {
	private Celula proximo;
	private Aluno valor;

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

	public Aluno getValor() {
		return valor;
	}

	public void setValor(Aluno valor) {
		this.valor = valor;
	}
}
