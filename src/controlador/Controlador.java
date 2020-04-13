package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(request.getServletPath().equalsIgnoreCase("/Login.do"))
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
		else if(request.getServletPath().equalsIgnoreCase("/paginaLogIn.do"))
		{
			request.getRequestDispatcher("Login.jsp").forward(request, response);
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
