package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pedido 
{
	


	private int id_ped;
	private int idcl_ped;
	private float tot_ped;
	private Date date_ped;
	//private int idemp_emp;
	private String est_ped;

	private String datePattern = "yyyy-MM-dd";
	 private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	public Pedido() {
		super();
	}

	public Pedido(int id_ped, int idcl_ped, float tot_ped) {
		super();
		this.id_ped = id_ped;
		this.idcl_ped = idcl_ped;
		this.tot_ped = tot_ped;
		//this.idemp_emp = idemp_emp;
	}

	public int getId_ped() {
		return id_ped;
	}

	public void setId_ped(int id_ped) {
		this.id_ped = id_ped;
	}

	public int getIdcl_ped() {
		return idcl_ped;
	}

	public void setIdcl_ped(int idcl_ped) {
		this.idcl_ped = idcl_ped;
	}

	public float getTot_ped() {
		return tot_ped;
	}

	public void setTot_ped(float tot_ped) {
		this.tot_ped = tot_ped;
	}
/*
	public int getIdemp_emp() {
		return idemp_emp;
	}

	public void setIdemp_emp(int idemp_emp) {
		this.idemp_emp = idemp_emp;
	}
*/
	public Date getDate_ped() 
	{
		return date_ped;
	}
	public void setDate_ped(Date date_ped) {
		this.date_ped = date_ped;
	}
	 public String getEst_ped() {
		return est_ped;
	}

	public void setEst_ped(String est_ped) {
		this.est_ped = est_ped;
	}

	public List<Pedido> buscarTodos()
	{
		String consultaSQL = "SELECT id_ped,idcl_ped,tot_ped,date_ped, est_ped from pedidos";
		DataBaseHelper <Pedido> helper = new DataBaseHelper<Pedido>();
		List<Pedido> listaPedidos = helper.seleccionarRegistros(consultaSQL, Pedido.class);
		return listaPedidos;
	}
	
	public List<Pedido> insertar ()
	{
		Date date_ped = new Date();
		String consultaSQL = "INSERT INTO pedidos(idcl_ped,tot_ped,date_ped, est_ped) VALUES";
		consultaSQL += "("+idcl_ped+", "+tot_ped+",'"+dateFormatter.format(date_ped.getTime())+"' , 'recibido')";
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		helper.modificarRegistro(consultaSQL);
		return buscarTodos();
	}
	public List<Pedido> buscar(String id_ped)
	{
		
		String consultaSQL = "SELECT * FROM pedidos WHERE id_ped = '"+id_ped+"'";
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		List<Pedido> pedido = helper.seleccionarRegistros(consultaSQL,Pedido.class);
		return pedido;
	}
	public List<Pedido> editar()
	{
		String consultaSQL = "UPDATE pedidos SET est_ped='"+est_ped+"' WHERE id_ped= "+id_ped;
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		helper.modificarRegistro(consultaSQL);
		return buscarTodos();
	}
	public List<Pedido> filtrarEstado(String est_ped)
	{
		String consultaSQL = "SELECT * FROM pedidos WHERE est_ped = '"+est_ped+"'";
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		List<Pedido> listaPedidos = helper.seleccionarRegistros(consultaSQL, Pedido.class);
		return listaPedidos;
	}

	public List<Pedido> filtroCliente(String info_cl) {
		// TODO Auto-generated method stub
		String consultaSQL = "SELECT * FROM pedidos WHERE idcl_ped = '"+info_cl+"'";
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		List<Pedido> listaPedidos = helper.seleccionarRegistros(consultaSQL, Pedido.class);
		return listaPedidos;
	}

	public List<Pedido> eliminar() {
		String consultaSQL = "DELETE FROM pedidos WHERE id_ped = "+id_ped;
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		helper.modificarRegistro(consultaSQL);
		return buscarTodos();
	}
}
