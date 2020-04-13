package modelo;

import java.util.List;


public class Usuario {
	
	private int id_usu;
	private int clav_usu;
	private String pass_usu;
	private int tip_usu;
	private String mail_usu;
	
	public Usuario(int id_usu, int clav_usu, String pass_usu, int tip_usu, String mail_usu) {
		super();
		this.id_usu = id_usu;
		this.clav_usu = clav_usu;
		this.pass_usu = pass_usu;
		this.tip_usu = tip_usu;
		this.mail_usu = mail_usu;
	}
	public Usuario(int clav_usu, String pass_usu) {
		super();
		this.clav_usu = clav_usu;
		this.pass_usu = pass_usu;
	}
	public int getId_usu() {
		return id_usu;
	}
	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}
	public int getClav_usu() {
		return clav_usu;
	}
	public void setClav_usu(int clav_usu) {
		this.clav_usu = clav_usu;
	}
	public String getPass_usu() {
		return pass_usu;
	}
	public void setPass_usu(String pass_usu) {
		this.pass_usu = pass_usu;
	}
	public int getTip_usu() {
		return tip_usu;
	}
	public void setTip_usu(int tip_usu) {
		this.tip_usu = tip_usu;
	}
	public String getMail_usu() {
		return mail_usu;
	}
	public void setMail_usu(String mail_usu) {
		this.mail_usu = mail_usu;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Usuario> signIn() {
		String consultaSQL = "SELECT * FROM usuarios WHERE clav_usu ="+clav_usu+" AND pass_usu = '"+pass_usu+"'";
		DataBaseHelper<Usuario> helper = new DataBaseHelper<Usuario>();
		List<Usuario> usuario = helper.seleccionarRegistros(consultaSQL, Usuario.class);
		return usuario;

	}
}
