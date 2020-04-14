package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Servicio;
import modelo.Usuario;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		//System.out.println(path);
		
		//--------------------Navegación----------------
		if(path.equalsIgnoreCase("/paginaLogIn.do"))
		{
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/paginaClientes.do"))
		{
			
			Cliente cliente = new Cliente();
			List<Cliente> listaClientes = cliente.buscarTodos();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("InsertarCliente.jsp").forward(request, response);
			
		}
		else if(path.equalsIgnoreCase("/paginaServicios.do"))
		{
			Servicio servicio = new Servicio();
			List<Servicio> listaServicios = servicio.buscarTodos();
			request.setAttribute("listaServicios",listaServicios);
			request.getRequestDispatcher("pagServicios.jsp").forward(request, response);

		}
		else if(path.equalsIgnoreCase("/paginaServiciosPub.do"))
		{
			Servicio servicio = new Servicio();
			List<Servicio> listaServicios = servicio.buscarTodos();
			request.setAttribute("listaServicios",listaServicios);
			request.getRequestDispatcher("paginaServiciosPub.jsp").forward(request, response);

		}
		else if(path.equalsIgnoreCase("/paginaEditarServicio.do"))
		{

			request.getRequestDispatcher("editarServicio.jsp").forward(request, response);

		}
		else if(path.equalsIgnoreCase("/paginaPedidos.do"))
		{
			
		}
		else if(path.equalsIgnoreCase("/Login.do"))
		{
			int usuario = Integer.parseInt(request.getParameter("txtUser"));
			String password = request.getParameter("txtPass");
			Usuario usu = new Usuario(usuario,password);
			//result debe tener solo un usuario
			List<Usuario> result = usu.signIn();
			if(result.isEmpty()) 
			{
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				//FALTA MANDAR ALERTA
				
			}
			else
			{
				request.getRequestDispatcher("Menu.jsp").forward(request, response);
				request.setAttribute("user", result.get(0));
			}
		}
		//----------------------------CRUD Cliente------------------------------------
		else if(path.equalsIgnoreCase("/insertarCliente.do"))
		{
			//int id_cl = Integer.parseInt(request.getParameter("id_cl"));
			String nom_cl = request.getParameter("nom_cl");
			String ape_cl = request.getParameter("ape_cl");
			String tel_cl = request.getParameter("tel_cl");
			Cliente cliente = new Cliente(nom_cl,ape_cl,tel_cl);
			//cliente.registrar();
			List<Cliente> listaClientes = cliente.buscarTodos();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("InsertarCliente.jsp").forward(request, response);
		}

		else if(path.equalsIgnoreCase("/buscarCliente.do"))
		{
			String info_cl = request.getParameter("info_cl");
			Cliente cliente = new Cliente();
			List<Cliente> clienteBuscado = cliente.buscar(info_cl); 
			request.setAttribute("clienteBuscado", clienteBuscado);
			List<Cliente> listaClientes = cliente.buscarTodos();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("InsertarCliente.jsp").forward(request, response);

		}
		else if(path.equalsIgnoreCase("/eliminarCliente.do"))
		{
			Cliente cliente = new Cliente();
			int id_cl = Integer.parseInt(request.getParameter("id_cl"));
			System.out.println(id_cl);
			//cliente.setId_cl(id_cl);
			//cliente.eliminar();
			List<Cliente> listaClientes = cliente.buscarTodos();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("InsertarCliente.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/paginaEditarCliente.do"))
		{
			String id_cl = request.getParameter("id_cl");
			String nom_cl = request.getParameter("nom_cl");
			String ape_cl = request.getParameter("ape_cl");
			String tel_cl = request.getParameter("tel_cl");
			request.setAttribute("id_cl", id_cl);
			request.setAttribute("nom_cl", nom_cl);
			request.setAttribute("ape_cl", ape_cl);
			request.setAttribute("tel_cl", tel_cl);
			request.getRequestDispatcher("EditarCliente.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/editarCliente.do"))
		{
			int id_cl = Integer.parseInt(request.getParameter("id_cl"));
			String nom_cl = request.getParameter("nom_cl");
			String ape_cl = request.getParameter("ape_cl");
			String tel_cl = request.getParameter("tel_cl");
			Cliente cliente = new Cliente(id_cl,nom_cl,ape_cl,tel_cl);
			List<Cliente> listaClientes= cliente.editar();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("InsertarCliente.jsp").forward(request, response);

		}
		//---------------------CRUD SERVICIOS------------------
		else if(path.equalsIgnoreCase("/insertarServicio.do")){
			String nom_ser = request.getParameter("nom_ser");
			float cost_ser = Float.parseFloat(request.getParameter("cost_ser"));
			String med_ser = request.getParameter("med_ser");
			Servicio servicio = new Servicio(nom_ser,cost_ser,med_ser);
			List<Servicio> listaServicios = servicio.registrar();
			request.setAttribute("listaServicios",listaServicios);
			request.getRequestDispatcher("pagServicios.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/eliminarServicio.do"))
		{
			Servicio servicio = new Servicio();
			int id_ser = Integer.parseInt(request.getParameter("id_ser"));
			System.out.println(id_ser);
			servicio.setId_ser(id_ser);
			servicio.eliminar();
			List<Servicio> listaServicios = servicio.eliminar();
			request.setAttribute("listaServicios", listaServicios);
			request.getRequestDispatcher("pagServicios.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
