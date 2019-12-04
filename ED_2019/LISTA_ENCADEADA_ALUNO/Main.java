package ed5;

import ed5.Aluno;

public class Main {

	public static void main(String[] args) {
		ListaEncadeada listaAlunos = new ListaEncadeada();
		Main main = new Main();
		main.adicionarAluno(listaAlunos);
		main.remover(listaAlunos);
		while(listaAlunos.temProximo()) {
			System.out.println(listaAlunos.getPosicaoAtual().getValor());
		}
	}
	
	private void adicionarAluno(ListaEncadeada listaAlunos) {
		
		Aluno a1 = new Aluno("01", "Wilson", "ED", 10, 10, 0);
		Aluno a2 = new Aluno("012", "Wilson", "ED", 10, 0, 10);
		Aluno a3 = new Aluno("0123", "Wilson", "ED", 10, 8, 0);
		Aluno a4 = new Aluno("01234", "Wilson", "ED", 10, 2, 10);
		Aluno a5 = new Aluno("012345", "Wilson", "ED", 1, 1, 8);
		Aluno a6 = new Aluno("0123456", "Wilson", "ED", 10, 1, 10);
		
		listaAlunos.adicionar(a1);
		listaAlunos.adicionar(a2);
		listaAlunos.adicionar(a3);
		listaAlunos.adicionar(a4);
		listaAlunos.adicionar(a5);
		listaAlunos.adicionar(a6);
	}
	
	private void remover(ListaEncadeada listaAlunos) {
		
		listaAlunos.remover();
		listaAlunos.remover();
		listaAlunos.remover();
		
	}

}
