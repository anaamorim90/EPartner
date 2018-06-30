package hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class Controller {

	private Modelo modelo;

	public Controller(Modelo modelo) {
		this.modelo = modelo;
	}

	public void buscarProfessor() {
		get("/func_professor/:matricula", (req, res) -> {

			// int matricula = Integer.parseInt(req.params(":matricula"));
			String termo = req.params(":matricula");
			List<Professor> professoresEncontrados = modelo.buscarProfessorSS(termo);
			return new Gson().toJson(professoresEncontrados);
		});
	}

	public void adicionarProfessor() {
		get("/func_professor/:c_matricula/:c_nome_completo/:c_email/:c_senha", (req, res) -> {
			Integer c_matricula = Integer.parseInt(req.params(":c_matricula"));
			String c_nome_completo = req.params(":c_nome_completo");
			String c_email = req.params(":c_email");
			String c_senha = req.params(":c_senha");
			modelo.cadastrarProfessor(new Professor(c_nome_completo, c_email, c_senha, c_matricula));
			return null;
		});
	}

	public void removerProfessor() {
		get("/func_professor/:e_email/:e_matricula", (req, res) -> {
			Integer e_matricula = Integer.parseInt(req.params(":e_matricula"));
			modelo.removerProfessor(e_matricula);
			return null;
		});
	}

	public void buscarAluno() {
		get("/func_aluno/:ra", (req, res) -> {

			// int ra = Integer.parseInt(req.params(":ra"));
			String termo = req.params(":ra");
			List<Aluno> alunosEncontrados = modelo.buscarAluno(termo);
			return new Gson().toJson(alunosEncontrados);
		});
	}

	public void removerAluno() {
		get("/func_aluno/remover/:ra", (req, res) -> {

			String termo = req.params(":ra");
			modelo.removerAluno(termo);
			return "removido";
		});
	}

	public void adicionarAluno() {
		get("/func_aluno/:c_ra/:c_nome_completo/:c_email/:c_senha/:c_curso/:c_data_nasc/:c_semestre/", (req, res) -> {

			String c_ra = (req.params(":c_ra"));
			String c_nome_completo = req.params(":c_nome_completo");
			String c_email = req.params(":c_email");
			String c_senha = req.params(":c_senha");
			String c_curso = req.params(":c_curso");
			String c_data_nasc = req.params(":c_data_nasc");
			int c_semestre = Integer.parseInt(req.params(":c_semestre"));

			modelo.cadastrarAluno(new Aluno(c_nome_completo, c_email, c_senha, c_ra, c_curso, c_data_nasc, c_semestre));
			return null;

		});
	}

	public void addAviso() {

		post("/prof_aviso/add", new Route() {

			public Object handle(final Request request, final Response response) {
				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());

				String c_dataInicial = json.getString("c_dataInicial");
				String c_dataFinal = json.getString("c_dataFinal");
				String c_materia = json.getString("c_materia");
				String c_descricao = json.getString("c_descricao");

				try {
					Aviso aviso = new Aviso(c_dataInicial, c_dataFinal, c_materia, c_descricao);

					if (aviso != null) {
						modelo.cadastrarAviso(aviso);
						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();

						jsonObj.put("status", 1);
						jsonObj.put("dataInicial", aviso.getDataInicial());
						jsonResult.put(jsonObj);

						return jsonResult;

					}

				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("status", 0);

				jsonResult.put(jsonObj);

				return jsonResult;
			}
		});

	}

	public void buscarAviso() {
		get("/prof_aviso/:termo", (req, res) -> {

			String termo = req.params(":termo");
			List<Aviso> avisosEncontrados = modelo.buscarAviso(termo);
			return new Gson().toJson(avisosEncontrados);
		});
	}

	public void loginAluno() {

		post("/login/aluno", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());

				String email = json.getString("email");

				String senha = json.getString("senha");

				try {
					Aluno aluno = modelo.loginAluno(email, senha);

					if (aluno != null) {
						System.out.println("entrei no controller");
						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();

						jsonObj.put("status", 1);
						jsonObj.put("userName", aluno.getEmail());

						jsonResult.put(jsonObj);

						return jsonResult;

					} else {

					}

				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("status", 0);

				jsonResult.put(jsonObj);

				return jsonResult;
			}
		});
	}

}
