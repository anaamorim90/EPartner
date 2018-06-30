package hello;

import static spark.Spark.*;



public class MainServer {
	
	final static Modelo modelo = new Modelo();
	//private static Modelo modelo;
	//modelo = modelo.getInstance();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 1223;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");
		
		//inicializarProfessor();
		inicializarAluno();
		inicializarAviso();
		
		Controller controller = new Controller(modelo);
		
		//controller.buscarProfessor();
		//controller.adicionarProfessor();
		//controller.removerProfessor();
		controller.buscarAluno();
		controller.adicionarAluno();	
		controller.removerAluno();
		controller.addAviso();
		controller.buscarAviso();
		controller.loginAluno();

		
    }
    
    //public static void inicializarProfessor(){
    	//List<String> disciplinas1 = new LinkedList<>();
    	//List<String> disciplinas2 = new LinkedList<>();
    	//List<String> disciplinas3 = new LinkedList<>();
    	
    	//disciplinas1.add("Algoritmos");
    	//disciplinas1.add("LP II");
    	//disciplinas2.add("Eng. Software");
    	//disciplinas2.add("Lab III");
    	//disciplinas3.add("Estruturas de dados");
    	
    	//modelo.cadastrarProfessor(new Professor("Giuliano", "giuliano.bertotti@fatec.com", "123qwe", 12345));
    	//modelo.cadastrarProfessor(new Professor("Nadalete", "lucas.nadalete@fatec.com", "123qwe", 12346));
    	//modelo.cadastrarProfessor(new Professor("Sakaue", "eduardo.sakaue@fatec.com", "123qwe", 12347));
    	
    	//modelo.getProfessores().get(0).setDisciplinas(disciplinas1);
    	//modelo.getProfessores().get(1).setDisciplinas(disciplinas2);
    	//modelo.getProfessores().get(2).setDisciplinas(disciplinas3);
    //}
    
    public static void inicializarAluno(){

    	
    	//modelo.cadastrarAluno(new Aluno("Ana Claudia Lourenco de Amorim Cirineu", "ana.cirineu@fatec.sp.gov.br", "123@na", "201812345", "Tecnologia em Banco de Dados", "30/11/1990", 3));
    	//modelo.cadastrarAluno(new Aluno("Vinicius Oliveira", "vinicius@fatec.sp.gov.br", "xxxxx", "222222", "Tecnologia em Banco de Dados", "12/12/1988" , 4));
    	//modelo.cadastrarAluno(new Aluno("Marcelo Augusto oliveira", "marcelou@fatec.sp.gov.br", "z1z1z1", "3333333", "Logistica", "10/01/1987", 3));
	
    }
    public static void inicializarAviso(){

}
    
}