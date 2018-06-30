package hello;

import java.util.LinkedList;
import java.util.List;


public class Aluno {
    private String nome;
    private String email;
    private String senha;
    private String ra;
    private String curso;
	List<MateriaAluno> materias = new LinkedList<MateriaAluno>();
	//ObjectContainer materias = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/materias.db4o");
    private String dataNasc;
    private int semestre;

    public Aluno(String nome, String email, String senha, String ra, String curso, String dataNasc, int semestre) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ra = ra;
        this.curso = curso;
        this.dataNasc = dataNasc;
        this.semestre = semestre;
    }

    public int visualizarFaltas(String codDisciplina) {
		//Query query = materias.query();
		//query.constrain(MateriaAluno.class);
		//ObjectSet<MateriaAluno> materias = query.execute();
		
        for (MateriaAluno materia:materias) {
            if (materia.getCodigoDisciplina().equals(codDisciplina)) return materia.getFalta();
        }
        return -1;
    }

    public double visualizarNotas(String codDisciplina) {
		//Query query = materias.query();
		//query.constrain(MateriaAluno.class);
		//ObjectSet<MateriaAluno> materias = query.execute();
		
        for (MateriaAluno materia:materias) {
            if (materia.getCodigoDisciplina().equals(codDisciplina)) return materia.getNota();
        }
        return -1;
    }

    public void cadastrarMateriaAluno(MateriaAluno materia) { 
    	materias.add(materia);
    	//materias.store(materia);
    	//materias.commit(); 
    }
    
    

    @Override
	public String toString() {
		return "Aluno [nome=" + nome + ", email=" + email + ", senha=" + senha + ", ra=" + ra + ", curso=" + curso
				+ ", materias=" + materias + ", dataNasc=" + dataNasc + ", semestre=" + semestre + "]";
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<MateriaAluno> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaAluno> materias) {
        this.materias = materias;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
