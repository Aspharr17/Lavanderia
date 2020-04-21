package modelo;

import java.util.List;

public class detallePedido {
	private int id_dped;
	private int idped_dped;
	private int idser_dped;
	private float cant_dped;
	private float tot_dped;
	private Servicio servicio; 
	
	public detallePedido() {
		// TODO Auto-generated constructor stub
	}
	public int getId_dped() {
		return id_dped;
	}
	public void setId_dped(int id_dped) {
		this.id_dped = id_dped;
	}
	public int getIdped_dped() {
		return idped_dped;
	}
	public void setIdped_dped(int idped_dped) {
		this.idped_dped = idped_dped;
	}
	public int getIdser_dped() {
		return idser_dped;
	}
	public void setIdser_dped(int idser_dped) {
		this.idser_dped = idser_dped;
	}
	public float getCant_dped() {
		return cant_dped;
	}
	public void setCant_dped(float cant_dped) {
		this.cant_dped = cant_dped;
	}
	public float getTot_dped() {
		return tot_dped;
	}
	public void setTot_dped(float tot_dped) {
		this.tot_dped = tot_dped;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void agregarServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public detallePedido(int id_dped, int idped_dped, int idser_dped, float cant_dped, float tot_dped) {
		super();
		this.id_dped = id_dped;
		this.idped_dped = idped_dped;
		this.idser_dped = idser_dped;
		this.cant_dped = cant_dped;
		this.tot_dped = tot_dped;
	}
	public detallePedido(int idser_dped, float cant_dped, float tot_dped) {
		super();
		this.idser_dped = idser_dped;
		this.cant_dped = cant_dped;
		this.tot_dped = tot_dped;
	}


	public detallePedido(int id_dped, int idped_dped, int idser_dped, float cant_dped, float tot_dped,
			Servicio servicio) {
		super();
		this.id_dped = id_dped;
		this.idped_dped = idped_dped;
		this.idser_dped = idser_dped;
		this.cant_dped = cant_dped;
		this.tot_dped = tot_dped;
		this.servicio = servicio;
	}
	public void insertar (List<detallePedido> listaDetallesDePedido)
	{
		
		String consultaSQL = "INSERT INTO detallesdepedido(idped_dped, idser_dped, cant_dped, tot_dped) VALUES";
		for(detallePedido dp: listaDetallesDePedido)
		{
			consultaSQL += "("+dp.getIdped_dped()+", "+dp.getIdser_dped()+
					", "+dp.getCant_dped()+", "+dp.getTot_dped()+"),";
		}
		 consultaSQL = consultaSQL.substring(0,consultaSQL.length()-1);
		 DataBaseHelper<detallePedido> helper = new DataBaseHelper<detallePedido>();
		helper.modificarRegistro(consultaSQL);
	}
	public List<detallePedido> buscar(String id_ped) {
		String consultaSQL = "SELECT * FROM detallesdepedido WHERE idped_dped = '"+id_ped+"'";
		DataBaseHelper<detallePedido> helper = new DataBaseHelper<detallePedido>();
		List<detallePedido> detalles = helper.seleccionarRegistros(consultaSQL,detallePedido.class);
		return detalles;
	}
	public void eliminar()
	{
		String consultaSQL = "DELETE FROM detallesdepedido WHERE idped_dped = "+idped_dped;
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		helper.modificarRegistro(consultaSQL);
		
	}
	
	
}
