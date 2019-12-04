package ed5;

public class Aluno {
	
	private String numero_Matricula;
	private String nome;
	private String disciplina;
	
	private float p1;
	private float p2;
	private float p3;
	
	
	public Aluno(String numero_Matricula, String nome, String disciplina, float p1, float p2, float p3) {
		super();
		this.numero_Matricula = numero_Matricula;
		this.nome = nome;
		this.disciplina = disciplina;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	@Override
	public String toString() {
		return "Aluno [numero_matricula =" +numero_Matricula + "nome = "+nome+ "]";
	}
	
	public String getNumero_Matricula() {
		return numero_Matricula;
	}
	public void setNumero_Matricula(String numero_Matricula) {
		this.numero_Matricula = numero_Matricula;
	}
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	public String getdisciplina() {
		return disciplina;
	}
	public void setdisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public float getP1() {
		return p1;
	}
	public void setP1(float p1) {
		this.p1 = p1;
	}
	public float getP2() {
		return p2;
	}
	public void setP2(float p2) {
		this.p2 = p2;
	}
	public float getP3() {
		return p3;
	}
	public void setP3(float p3) {
		this.p3 = p3;
	}
	

}
