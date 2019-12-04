package edu.curso.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.curso.entidade.Aluno;

public class AlunoDAOImplementation implements AlunoDAO {

	@Override
	public void adicionar(Aluno a) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist( a );
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Aluno atualizar(long id, Aluno a) {
		EntityManager em = JPAUtil.getEntityManager();
		Aluno aOld = em.getReference(Aluno.class, id);
		if (aOld != null) { 
			em.getTransaction().begin();
			aOld.setIdade( a.getIdade() );
			aOld.setNascimento( a.getNascimento() );
			aOld.setNome( a.getNome());
			aOld.setRa( a.getRa() );
			em.getTransaction().commit();	
		} else {
			aOld = new Aluno();
		}
		em.close();
		return aOld;
	}

	@Override
	public List<Aluno> pesquisarPorNome(String nome) {
		EntityManager em = JPAUtil.getEntityManager();

		List<Aluno> lista = new ArrayList<Aluno>();
		
		TypedQuery<Aluno> qry = em.createQuery(
		"select a from alunos a where a.nome like :n", 
		Aluno.class);
		qry.setParameter("n", "%" + nome + "%");
		
		lista = qry.getResultList();
		
		em.close();
		return lista;
	}

	@Override
	public Aluno pesquisarPorRA(String ra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> pesquisarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
