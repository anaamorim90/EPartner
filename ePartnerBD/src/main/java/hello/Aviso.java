package hello;

//import java.time.LocalDate;
//import java.time.LocalTime;

public class Aviso {
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    //private LocalTime horarioInicial;
    //private LocalTime horarioFinal;
    private String materia;

    public Aviso(String dataInicial, String dataFinal, String materia, String descricao) {
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        //this.horarioInicial = horarioInicial;
        //this.horarioFinal = horarioFinal;
        this.materia = materia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }


    public String getMateria() { 
    	return materia; 
    }

    public void setMateria(String materia) { 
    	this.materia = materia; 
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aviso [descricao=").append(descricao).append(", dataInicial=").append(dataInicial)
				.append(", dataFinal=").append(dataFinal).append(", materia=").append(materia)
				.append(", getDescricao()=").append(getDescricao()).append(", getDataInicial()=")
				.append(getDataInicial()).append(", getDataFinal()=").append(getDataFinal()).append(", getMateria()=")
				.append(getMateria()).append("]");
		return builder.toString();
	}
    
    
}
