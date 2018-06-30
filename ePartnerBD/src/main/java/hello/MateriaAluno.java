package hello;

public class MateriaAluno {
    private double notas;
    private boolean finalizada;
    private int faltas;
    private String codigoDisciplina;

    public MateriaAluno(double nota, boolean finalizada, int falta, String codigoDisciplina) {
        this.notas = nota;
        this.finalizada = finalizada;
        this.faltas = falta;
        this.codigoDisciplina = codigoDisciplina;
    }

    public double getNota() { return notas; }

    public void setNota(double nota) {
        this.notas = nota;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public int getFalta() { return faltas; }

    public void setFalta(int falta) {
        this.faltas = falta;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
}
