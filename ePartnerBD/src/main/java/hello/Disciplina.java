package hello;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int professor;
    private String ementa;
    private List<Integer> alunos = new LinkedList<Integer>();
    private LocalTime horario;
    private String diaDaSemana;
    private int semestre;
    private String codigo;

    public Disciplina(String nome, int professor, String ementa, LocalTime horario, String diaDaSemana, int semestre, String codigo) {
        this.nome = nome;
        this.professor = professor;
        this.ementa = ementa;
        this.horario = horario;
        this.diaDaSemana = diaDaSemana;
        this.semestre = semestre;
        this.codigo = codigo;
    }

    public void matricularAluno(Integer matricula) {
        alunos.add(matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public List<Integer> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Integer> alunos) {
        this.alunos = alunos;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
