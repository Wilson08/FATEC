package edu.curso.dao;

import java.util.Date;
import java.util.List;

import edu.curso.entidade.Aluno;

public interface AlunoDAO {

	public void adicionar(Aluno a);
	public void remover(long id);
	public void atualizar(long id, Aluno a);
	public Aluno pesquisarPorRA(String ra);
	public List<Aluno> pesquisarPorNascimento(Date d);
	public List<Aluno> pesquisarTodos();
	public List<Aluno> pesquisarPorNome(String nome);
	
}
