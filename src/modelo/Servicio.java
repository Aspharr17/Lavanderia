package modelo;

import java.util.List;

public class Servicio {

	private int id_ser;
	private String nom_ser;
	private float cost_ser;
	private String med_ser;	
	
	public int getId_ser() {
		return id_ser;
	}

	public void setId_ser(int id_ser) {
		this.id_ser = id_ser;
	}

	public String getNom_ser() {
		return nom_ser;
	}

	public void setNom_ser(String nom_ser) {
		this.nom_ser = nom_ser;
	}

	public float getCost_ser() {
		return cost_ser;
	}

	public void setCost_ser(float cost_ser) {
		this.cost_ser = cost_ser;
	}

	public String getMed_ser() {
		return med_ser;
	}

	public void setMed_ser(String med_ser) {
		this.med_ser = med_ser;
	}

	public Servicio(int id_ser, String nom_ser, float cost_ser, String med_ser) {
		super();
		this.id_ser = id_ser;
		this.nom_ser = nom_ser;
		this.cost_ser = cost_ser;
		this.med_ser = med_ser;
	}

	public Servicio(String nom_ser, float cost_ser, String med_ser) {
		super();
		this.nom_ser = nom_ser;
		this.cost_ser = cost_ser;
		this.med_ser = med_ser;
	}

	public Servicio() {
		// TODO Auto-generated constructor stub
	}
	public List<Servicio> registrar()
	{
		String consultaSQL = "INSERT INTO servicios(nom_ser,cost_ser,med_ser) VALUES";
		consultaSQL +="('"+nom_ser+"', '"+cost_ser+"', '"+med_ser+"' )";
		DataBaseHelper<Servicio> helper = new DataBaseHelper<Servicio>();
		helper.modificarRegistro(consultaSQL);
		return buscarTodos();
	}
	public Servicio buscar(String info_ser)
	{
		String consultaSQL = "SELECT * FROM servicios WHERE nom_ser = '"+info_ser+"'";
		DataBaseHelper<Servicio> helper = new DataBaseHelper<Servicio>();
		List<Servicio> servicio = helper.seleccionarRegistros(consultaSQL,Servicio.class);
		return servicio.get(0);
	}
	public List<Servicio> buscarTodos()
	{
		String consultaSQL = "SELECT id_ser,nom_ser,cost_ser,med_ser from servicios";
		DataBaseHelper <Servicio> helper = new DataBaseHelper<Servicio>();
		List<Servicio> listaServicios = helper.seleccionarRegistros(consultaSQL, Servicio.class);
		return listaServicios;
	}
	public List<Servicio> eliminar()
	{
		String consultaSQL = "DELETE FROM servicios WHERE id_ser = "+id_ser;
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		System.out.println(consultaSQL);
		//helper.modificarRegistro(consultaSQL);
		return buscarTodos();
	}
	public List<Servicio> editar()
	{
		String consultaSQL = "UPDATE servicios SET nom_ser='"+nom_ser+"' , cost_ser = '"+cost_ser+"', med_ser = '"+med_ser+
							"' WHERE id_ser= "+id_ser;
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
		return buscarTodos();
	}

}
