package edu.curso.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.curso.entidade.Aluno;

public class AlunoDAOImplementation 
		implements AlunoDAO {

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
	public void atualizar(long id, Aluno a) {
		EntityManager em = JPAUtil.getEntityManager();
		Aluno oldAluno = em.getReference(Aluno.class, id);
		if (oldAluno != null) { 
			em.getTransaction().begin();
			oldAluno.setIdade( a.getIdade() );
			oldAluno.setNome( a.getNome() );
			oldAluno.setRa( a.getRa() );
			oldAluno.setNascimento( a.getNascimento() );
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public Aluno pesquisarPorRA(String ra) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Aluno> qry = em.
			createQuery("select a from alunos a where a.ra = :r", 
						Aluno.class);
			qry.setParameter("r", ra);
		Aluno a = qry.getSingleResult();
		if (a == null) {
			a = new Aluno();
		}
		em.close();
		return a;
	}

	@Override
	public List<Aluno> pesquisarPorNascimento(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> pesquisarTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Aluno> qry = em.
				createQuery("select a from alunos a", Aluno.class);
		List<Aluno> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Aluno>();
		}
		em.close();
		return lista;
	}

	@Override
	public List<Aluno> pesquisarPorNome(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Aluno> qry = em.
			createQuery("select a from alunos a where a.nome like :n", 
						Aluno.class);
			qry.setParameter("n", nome);
		List<Aluno> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Aluno>();
		}
		em.close();
		return lista;
	}

}
