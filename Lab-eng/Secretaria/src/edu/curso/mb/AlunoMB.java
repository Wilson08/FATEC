package edu.curso.mb;

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

	private static final long serialVersionUID = 1402178303413714619L;
	private Aluno alunoAtual;
	private List<Aluno> alunos;
	private String selecao;
	
	public AlunoMB() { 
		setAlunoAtual( new Aluno() );
		setAlunos( new ArrayList<Aluno>() );
	}
	
	public String remover( long id ) {
		
		FacesContext.getCurrentInstance()
		.addMessage(null, 
		new FacesMessage("Aluno com ID " + 
							id + 
							" foi removido com sucesso") );
		
		// Codigo para remover o Aluno com o Id recebido como parametro..
		
		return " ";
	}
	
	public String adicionar() { 
		AlunoDAO aDao = new AlunoDAOImplementation();
		aDao.adicionar( alunoAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Usuario " + 
								alunoAtual.getNome() + 
								" cadastrado com sucesso") );
		
		alunoAtual = new Aluno();
		return " ";
	}
	
	public String atualizar() { 
		AlunoDAO aDao = new AlunoDAOImplementation();
		aDao.atualizar( alunoAtual.getId(), alunoAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Usuario " + 
								alunoAtual.getNome() + 
								" atualizado com sucesso") );
		
		//alunoAtual = new Aluno();
		return " ";
	}
	
	public String pesquisar() {
		AlunoDAO aDao = new AlunoDAOImplementation();
		if ("todos".equals(selecao)) { 
			alunos = aDao.pesquisarTodos();
		} else if ("pornome".equals(selecao)) { 
			alunos = aDao.pesquisarPorNome( alunoAtual.getNome() );
		} else if ("porra".equals(selecao)) { 
			alunoAtual = aDao.pesquisarPorRA( alunoAtual.getRa() );
		}
		return " ";
	}
	
	public Aluno getAlunoAtual() {
		return alunoAtual;
	}
	public void setAlunoAtual(Aluno alunoAtual) {
		this.alunoAtual = alunoAtual;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}	
}
