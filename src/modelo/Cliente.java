package modelo;

import java.util.List;

public class Cliente {
	private int id_cl;
	private String nom_cl;
	private String ape_cl;
	private String tel_cl;
	public Cliente(int id_cl, String nom_cl, String ape_cl, String tel_cl) {
		super();
		this.id_cl = id_cl;
		this.nom_cl = nom_cl;
		this.ape_cl = ape_cl;
		this.tel_cl = tel_cl;
	}
	public int getId_cl() {
		return id_cl;
	}
	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
	}
	public String getNom_cl() {
		return nom_cl;
	}
	public void setNom_cl(String nom_cl) {
		this.nom_cl = nom_cl;
	}
	public String getApe_cl() {
		return ape_cl;
	}
	public void setApe_cl(String ape_cl) {
		this.ape_cl = ape_cl;
	}
	public String getTel_cl() {
		return tel_cl;
	}
	public void setTel_cl(String tel_cl) {
		this.tel_cl = tel_cl;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void registrarCliente()
	{
		String consultaSQL = "INSERT INTO clientes(id_cl,nom_cl,ape_cl,tel_cl) VALUES";
		consultaSQL +="("+id_cl+", '"+nom_cl+"', '"+ape_cl+"', '"+tel_cl+"' )";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
	}
	public List<Cliente> buscarTodos()
	{
		String consultaSQL = "SELECT id_cl,nom_cl,ape_cl,tel_cl from clientes";
		DataBaseHelper <Cliente> helper = new DataBaseHelper<Cliente>();
		List<Cliente> listaClientes = helper.seleccionarRegistros(consultaSQL, Cliente.class);
		return listaClientes;
	}
	public List<Cliente> buscarCliente()
	{
		String consultaSQL = "SELECT * FROM clientes WHERE id_cl ="+id_cl+
							" OR nom_cl ='"+nom_cl+"' OR ape_cl = '"+ape_cl+"' OR tel_cl ='"+tel_cl+"'";
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		List<Cliente> cliente = helper.seleccionarRegistros(consultaSQL,Cliente.class);
		return cliente;
	}
	public void eliminarCliente()
	{
		String consultaSQL = "DELETE FROM clientes WHERE id_cl = "+id_cl;
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
	}
	public void editarCliente()
	{
		String consultaSQL = "UPDATE clientes SET nom_cl='"+nom_cl+"' , ape_cl = '"+ape_cl+"', tel_cl = '"+tel_cl+
							"' WHERE id_cl= "+id_cl;
		DataBaseHelper<Cliente> helper = new DataBaseHelper<Cliente>();
		helper.modificarRegistro(consultaSQL);
	}
	
}
