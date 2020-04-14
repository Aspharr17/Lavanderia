package modelo;

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

	public Servicio() {
		// TODO Auto-generated constructor stub
	}

}
