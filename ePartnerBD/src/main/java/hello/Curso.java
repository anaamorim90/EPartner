package hello;

import java.util.LinkedList;
import java.util.List;

public class Curso {
    private String nome;
    private List<Disciplina> disciplinas = new LinkedList<Disciplina>();

    public Curso(String nome) {
        this.nome = nome;
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        if (isDisciplinaAvaiable(disciplina.getCodigo())) disciplinas.add(disciplina);
    }

    public boolean isDisciplinaAvaiable(String codigo) {
        for (Disciplina disciplina: disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
