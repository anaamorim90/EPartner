package hello;

import java.util.LinkedList;
import java.util.List;


public class Professor {
    private String nome;
    private String email;
    private String senha;
    private int matricula;
	List<String> disciplinas = new LinkedList<>();
	//ObjectContainer disciplinas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/disciplinas.db4o");

    public Professor(String nome, String email, String senha, int matricula) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
    }

    @Override
	public String toString() {
		return this.nome + " " + this.email + " " + this.matricula+ " " + this.disciplinas;
	}

	public void adicionarDisciplina(String disciplina) {
		disciplinas.add(disciplina);
        //disciplinas.store(disciplina);
        //disciplinas.commit();
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<String> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
