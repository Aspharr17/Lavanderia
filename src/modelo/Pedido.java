package modelo;

import java.sql.Date;

public class Pedido 
{
	
	private int id;
	private int idcl;
	private float tot;
	//private Date date;
	private int idemp;
	
	
	public Pedido(int id, int idcl, float tot, Date date) {
		super();
		this.id = id;
		this.idcl = idcl;
		this.tot = tot;
		//this.date = date;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdcl() {
		return idcl;
	}
	public void setIdcl(int idcl) {
		this.idcl = idcl;
	}
	public float getTot() {
		return tot;
	}
	public void setTot(float tot) {
		this.tot = tot;
	}
	/*public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/
	public Pedido() 
	{
		
	}
	
	public void insertar ()
	{
		String consultaSQL = "INSERT INTO pedidos(id_ped,idcl_ped,tot_ped,idemp_emp) VALUES";
		consultaSQL += "("+id+", "+idcl+", "+tot+", "+", "+idemp+")";
		DataBaseHelper<Pedido> helper = new DataBaseHelper<Pedido>();
		helper.modificarRegistro(consultaSQL);
	}
}
