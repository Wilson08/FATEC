package edu.curso.dao;

import java.util.List;

import edu.curso.entidade.Aluno;

public interface AlunoDAO {
	
	public void adicionar(Aluno a);
	public void remover(long id);
	public Aluno atualizar(long id, Aluno a);
	public List<Aluno> pesquisarPorNome(String nome);
	public Aluno pesquisarPorRA(String ra);
	public List<Aluno> pesquisarTodos();

}
