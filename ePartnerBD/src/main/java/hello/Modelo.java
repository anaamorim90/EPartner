package hello;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Modelo {
	ObjectContainer professores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/professores.db4o");
	ObjectContainer alunos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/alunos.db4o");
	ObjectContainer funcionarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/funcionarios.db4o");
	ObjectContainer cursos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/cursos.db4o");
	ObjectContainer avisos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/avisos.db4o");
	// private static Modelo uniqueInstance;

	// private Modelo() {
	// }

	// private static Modelo getInstance() {
	// if (uniqueInstance == null) {
	// uniqueInstance = new Modelo();
	// }
	// return uniqueInstance;
	// }

	public List<Professor> buscarProfessorSS(String termo) {
		List<Professor> professoresEncontrados = new LinkedList<>();
		Query query = professores.query();
		query.constrain(Professor.class);
		ObjectSet<Professor> professores = query.execute();

		for (Professor professor : professores) {
			if (professor.toString().contains(termo)) {
				professoresEncontrados.add(professor);
			}
		}
		return professoresEncontrados;
	}

	public List<Aluno> buscarAluno(String termo) {
		List<Aluno> alunosEncontrados = new LinkedList<Aluno>();
		Query query = alunos.query();
		query.constrain(Aluno.class);
		ObjectSet<Aluno> allAlunos = query.execute();

		for (Aluno aluno : allAlunos) {
			if (aluno.toString().toLowerCase().contains(termo.toLowerCase()))
				alunosEncontrados.add(aluno);
		}
		return alunosEncontrados;
	}

	public List<Aviso> buscarAviso(String termo) {
		List<Aviso> avisosEncontrados = new LinkedList<Aviso>();
		Query query = avisos.query();
		query.constrain(Aviso.class);
		ObjectSet<Aviso> allAvisos = query.execute();

		for (Aviso aviso : allAvisos) {
			if (aviso.toString().toLowerCase().contains(termo.toLowerCase()))
				avisosEncontrados.add(aviso);
		}
		return avisosEncontrados;
	}

	public void removerAluno(String ra) {
		Query query = alunos.query();
		query.constrain(Aluno.class);
		List<Aluno> allAlunos = query.execute();

		for (Aluno aluno : allAlunos) {
			if (aluno.getRa().toLowerCase().equals(ra)) {
				alunos.delete(aluno);
				alunos.commit();
			}
		}
	}

	@Override
	public String toString() {
		return "Modelo [professores=" + professores + ", alunos=" + alunos + ", cursos=" + cursos + ", avisos=" + avisos
				+ ", funcionarios=" + funcionarios + "]";
	}

	public int buscarFaltas(int ra, String codDisciplina) {
		int faltas = 0;
		Query query = alunos.query();
		query.constrain(Aluno.class);
		ObjectSet<Aluno> alunos = query.execute();

		for (Aluno aluno : alunos) {
			if (aluno.getRa().equals(ra)) {
				faltas = aluno.visualizarFaltas(codDisciplina);
			}
		}
		return faltas;
	}

	public double buscarNotas(int ra, String codDisciplina) {
		double notas = 0;
		Query query = alunos.query();
		query.constrain(Aluno.class);
		ObjectSet<Aluno> alunos = query.execute();

		for (Aluno aluno : alunos) {
			if (aluno.getRa().equals(ra)) {
				notas = aluno.visualizarNotas(codDisciplina);
			}
		}
		return notas;
	}

	public Aviso visualizarAviso(String codDisciplina) {
		Query query = avisos.query();
		query.constrain(Aviso.class);
		ObjectSet<Aviso> avisos = query.execute();

		for (Aviso aviso : avisos) {
			if (aviso.getMateria().equals(codDisciplina)) {
				return aviso;
			}
		}
		return null;
	}

	public Aluno isAlunoAvaiable(String email, String ra) {
		Query query = alunos.query();
		query.constrain(Aluno.class);
		ObjectSet<Aluno> alunos = query.execute();

		for (Aluno aluno : alunos) {
			if (aluno.getRa().toLowerCase().equals(ra.toLowerCase()) || aluno.getEmail().toLowerCase().equals(email.toLowerCase())) {
				removerAluno(ra);
				return null;
			}
		}
		return null;
	}

	public boolean isProfessorAvaiable(String email, int matricula) {
		Query query = professores.query();
		query.constrain(Professor.class);
		ObjectSet<Professor> professores = query.execute();

		for (Professor professor : professores) {
			if (professor.getMatricula() == matricula && professor.getEmail().equals(email))
				return false;
		}
		return true;
	}

	public boolean isFuncionarioAvaiable(String email, int matricula) {
		Query query = funcionarios.query();
		query.constrain(Funcionario.class);
		ObjectSet<Funcionario> funcionarios = query.execute();

		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getMatricula() == matricula && funcionario.getEmail().equals(email))
				return false;
		}
		return true;
	}

	public boolean isCursoAvaiable(String nome) {
		Query query = cursos.query();
		query.constrain(Curso.class);
		ObjectSet<Curso> cursos = query.execute();

		for (Curso curso : cursos) {
			if (curso.getNome().equals(nome))
				return false;
		}
		return true;
	}

	public void cadastrarAluno(Aluno aluno1) {

		if (isAlunoAvaiable(aluno1.getEmail(), aluno1.getRa()) == null) {
			alunos.store(aluno1);
			alunos.commit();
		}
	}

	public void cadastrarProfessor(Professor professor1) {

		if (isProfessorAvaiable(professor1.getEmail(), professor1.getMatricula()))
			professores.store(professor1);
		professores.commit();

	}

	public void cadastrarCurso(Curso curso) {
		Query query = cursos.query();
		query.constrain(Curso.class);
		ObjectSet<Curso> cursos = query.execute();

		if (isCursoAvaiable(curso.getNome()))
			cursos.add(curso);
	}

	public void cadastrarAviso(Aviso aviso) {
		avisos.store(aviso);
		avisos.commit();

		// return aviso;
	}

	public void cadastrarFuncionario(Funcionario funcionario) {
		Query query = funcionarios.query();
		query.constrain(Funcionario.class);
		ObjectSet<Funcionario> funcionarios = query.execute();

		if (isFuncionarioAvaiable(funcionario.getEmail(), funcionario.getMatricula()))
			funcionarios.add(funcionario);
	}

	public void removerProfessor(Integer matricula) {
		Query query = professores.query();
		query.constrain(Professor.class);
		ObjectSet<Professor> professores = query.execute();

		for (int i = 0; i < professores.size(); i++) {
			if (professores.get(i).getMatricula() == matricula)
				professores.remove(i);
		}
	}

	public Aluno loginAluno(String username, String password) {

		Query query = alunos.query();
		query.constrain(Aluno.class);
		ObjectSet<Aluno> allAlunos = query.execute();

		for (Aluno aluno : allAlunos) {
			if (aluno.getEmail().toLowerCase().equals(username.toLowerCase()) && aluno.getSenha().toLowerCase().equals(password.toLowerCase())) {
				return aluno;
			}
		}
		return null;
	}

	public ObjectContainer getProfessores() {
		return professores;
	}

	public void setProfessores(ObjectContainer professores) {
		this.professores = professores;
	}

	public ObjectContainer getAlunos() {
		return alunos;
	}

	public void setAlunos(ObjectContainer alunos) {
		this.alunos = alunos;
	}

	public ObjectContainer getCurso() {
		return cursos;
	}

	public void setCurso(ObjectContainer curso) {
		this.cursos = curso;
	}

	public ObjectContainer getAvisos() {
		return avisos;
	}

	public void setAvisos(ObjectContainer avisos) {
		this.avisos = avisos;
	}

	public ObjectContainer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ObjectContainer funcionarios) {
		this.funcionarios = funcionarios;
	}
}
