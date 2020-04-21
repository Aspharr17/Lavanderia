package modelo;

import java.util.List;

public class Estado {
	private int id_est;
	private String nom_est;
	

	public Estado(int id_est, String nom_est) {
		super();
		this.id_est = id_est;
		this.nom_est = nom_est;
	}


	public int getId_est() {
		return id_est;
	}


	public void setId_est(int id_est) {
		this.id_est = id_est;
	}


	public String getNom_est() {
		return nom_est;
	}


	public void setNom_est(String nom_est) {
		this.nom_est = nom_est;
	}


	public Estado() {
		// TODO Auto-generated constructor stub
	}
	public List<Estado> buscarTodos()
	{
		String consultaSQL = "SELECT * from estados";
		DataBaseHelper <Estado> helper = new DataBaseHelper<Estado>();
		List<Estado> listaEstados = helper.seleccionarRegistros(consultaSQL, Estado.class);
		return listaEstados;
	}

}
