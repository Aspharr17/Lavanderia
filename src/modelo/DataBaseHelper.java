package modelo;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseHelper <T> {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/lavanderia";
	private static final String USUARIO = "UsuarioBDLavan";
	private static final String CLAVE = "12345Lavan";


	public int modificarRegistro(String consultaSQL)
	{
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		
		try
		{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
			
		}catch(ClassNotFoundException e) {
			System.out.println("Error driver"+e.getMessage());
		}catch(SQLException e) {
			System.out.println("Error de SQL"+e.getMessage());
		}finally {
			
			if(sentencia != null) {
				try {sentencia.close();} catch(SQLException e) {}
			}
			if(conexion != null) {
				try {conexion.close();}catch(SQLException e) {}
			}
		}
		return filasAfectadas;
	}

	@SuppressWarnings({ "finally", "unchecked", "rawtypes" })
	public List<T> seleccionarRegistros(String consultaSQL, Class clase) 
	{
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos=new ArrayList<T>();
		try 
		{

			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
			while (filas.next()) 
			{

				T objeto=(T) Class.forName(clase.getName()).newInstance();
				Method[] metodos=objeto.getClass().getDeclaredMethods();
				for (int i=0;i<metodos.length;i++) 
				{
					
					if (metodos[i].getName().startsWith("set") ) 
					{

						if(isNumeric(filas.getString(metodos[i].getName().substring(3))))
						{
							metodos[i].invoke(objeto,filas.getInt(metodos[i].getName().substring(3)));
						}
						else if(metodos[i].getName().equals("setTel_cl"))
						{
							metodos[i].invoke(objeto,filas.getString(metodos[i].getName().substring(3)));

						}
						else if(isFloat(filas.getString(metodos[i].getName().substring(3))))
						{	
							metodos[i].invoke(objeto,filas.getFloat(metodos[i].getName().substring(3)));
						}
						else if(isDate(filas.getString(metodos[i].getName().substring(3))))
						{

							metodos[i].invoke(objeto,filas.getDate(metodos[i].getName().substring(3)));
						}
						else
						{

							metodos[i].invoke(objeto,filas.getString(metodos[i].getName().substring(3)));

						}
					}
					if (objeto.getClass().getName().equals("java.lang.String")) 
					{
						objeto=(T)filas.getString(1);
					}
				}	
				listaDeObjetos.add(objeto);
			}
		} catch (Exception e) {
		System.out.println("Error al seleccionar registros" + e.getMessage());
		}
		finally {
		if (sentencia != null) {
		try {sentencia.close();} catch (SQLException e) {}
		}
		if (conexion != null) {
		try {conexion.close();} catch (SQLException e) {}
		}
		return listaDeObjetos;
		}
	}
	private static boolean isNumeric(String cadena){
		try {
			
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	private static boolean isFloat(String cadena){
		try {
			Float.parseFloat(cadena);

			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	private static boolean isDate(String cadena)
	{
		try 
		{
			DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			inputDateFormat.parse(cadena);
			
			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
