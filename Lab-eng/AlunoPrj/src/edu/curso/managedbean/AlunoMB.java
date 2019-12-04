package edu.curso.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.curso.dao.AlunoDAO;
import edu.curso.dao.AlunoDAOImplementation;
import edu.curso.entidade.Aluno;

@ManagedBean
@ViewScoped
public class AlunoMB implements Serializable {

	private static final long serialVersionUID = 5425116284534362545L;
	
	private Aluno aluno;
	private List<Aluno> alunos;
	
	public AlunoMB() { 
		setAluno(new Aluno());
		setAlunos(new ArrayList<Aluno>());
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public String adicionar() {
		AlunoDAO aDao = new AlunoDAOImplementation();
		aDao.adicionar( getAluno() );
		setAluno ( new Aluno() );
		FacesContext.getCurrentInstance()
				.addMessage(null,
							new FacesMessage(
									"Usuario adicionado com sucesso"
							)
				);
		return " ";
	}
	
	public String atualizar() {
		AlunoDAO aDao = new AlunoDAOImplementation();
		setAluno( aDao.atualizar( getAluno().getId(), getAluno() ) );
		setAluno ( new Aluno() );
		FacesContext.getCurrentInstance()
		.addMessage(null,
					new FacesMessage(
							"Usuario atualizado com sucesso"
					)
		);
		return " ";
	}
	
	public String pesquisar() { 
		AlunoDAO aDao = new AlunoDAOImplementation();
		setAlunos( aDao.pesquisarPorNome( getAluno().getNome() ) );
		FacesContext.getCurrentInstance()
		.addMessage(null,
					new FacesMessage(
							"Foram encontrados " + getAlunos().size() +
							" registros"
					)
		);
		return " ";
	}
	
	

}
