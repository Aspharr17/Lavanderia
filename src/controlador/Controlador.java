package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Servicio servicio = new Servicio();
	List<Servicio> listaServicios = servicio.buscarTodos();
	Cliente cliente = new Cliente();
	List<Cliente> listaClientes = cliente.buscarTodos();
	Pedido pedido = new Pedido();
	List<Pedido> listaPedidos = pedido.buscarTodos();
	Estado estado = new Estado();
	List<Estado> listaEstados = estado.buscarTodos();
	
	//Objetos para buscar un pedido específico
	List<Pedido> listaPedido;
	Pedido pedidoBuscado = new Pedido();
	Cliente clientePedido;
	List<detallePedido> listaDetallesDePedido = new ArrayList<detallePedido>();


	
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
		if(path.equalsIgnoreCase("/home.do"))
		{
			int recibidos = 0;
			int proceso= 0;
			int listos=0;
			for(Pedido ped : listaPedidos)
			{
				String est_ped = ped.getEst_ped();
				switch (est_ped)
				{
				case "recibido":
					recibidos++;
					break;
				case "procesando":
					proceso++;
					break;
				case "listo":
					listos++;
					break;
				default:
					break;
				}
			}
			request.setAttribute("recibidos",recibidos);
			request.setAttribute("proceso", proceso);
			request.setAttribute("listos",listos);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/paginaClientes.do"))
		{
			
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("paginaCliente.jsp").forward(request, response);
			
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
			request.setAttribute("listaServicios",listaServicios);
			request.getRequestDispatcher("paginaServiciosPub.jsp").forward(request, response);

		}
		else if(path.equalsIgnoreCase("/nuevoPedido.do"))
		{
			String info_cl = request.getParameter("info_cl");
			Cliente cliente = new Cliente();
			List<Cliente> clienteBuscado = cliente.buscar(info_cl); 
			request.setAttribute("clienteBuscado", clienteBuscado);
			request.getRequestDispatcher("clientePedido.jsp").forward(request, response);
			
		}
		
		else if(path.equalsIgnoreCase("/paginaPedidos.do"))
		{
			List<Pedido> listaPedidos = this.listaPedidos;
			Collections.sort(listaPedidos, new Comparator<Pedido>() {
				@Override
				public int compare(Pedido p1, Pedido p2) {
					return new Integer(p2.getId_ped()).compareTo(new Integer(p1.getId_ped()));
				}
			});
			request.setAttribute("listaEstados", listaEstados);
			request.setAttribute("listaPedidos", listaPedidos);
			request.getRequestDispatcher("paginaPedidos.jsp").forward(request, response);
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
			listaClientes = cliente.registrar();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("paginaCliente.jsp").forward(request, response);
		}

		else if(path.equalsIgnoreCase("/buscarCliente.do"))
		{
			String info_cl = request.getParameter("info_cl");
			Cliente cliente = new Cliente();
			List<Cliente> clienteBuscado = cliente.buscar(info_cl); 
			request.setAttribute("clienteBuscado", clienteBuscado);
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("paginaCliente.jsp").forward(request, response);

		}
		else if(path.equalsIgnoreCase("/eliminarCliente.do"))
		{
			Cliente cliente = new Cliente();
			int id_cl = Integer.parseInt(request.getParameter("id_cl"));
			cliente.setId_cl(id_cl);
			listaClientes = cliente.eliminar();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("paginaCliente.jsp").forward(request, response);
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
			listaClientes= cliente.editar();
			request.setAttribute("listaClientes", listaClientes);
			request.getRequestDispatcher("paginaCliente.jsp").forward(request, response);

		}
		//---------------------CRUD SERVICIOS------------------
		else if(path.equalsIgnoreCase("/insertarServicio.do")){
			String nom_ser = request.getParameter("nom_ser");
			float cost_ser = Float.parseFloat(request.getParameter("cost_ser"));
			String med_ser = request.getParameter("med_ser");
			Servicio servicio = new Servicio(nom_ser,cost_ser,med_ser);
			listaServicios = servicio.registrar();
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
			listaServicios = servicio.eliminar();
			request.setAttribute("listaServicios", listaServicios);
			request.getRequestDispatcher("pagServicios.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/paginaEditarServicio.do"))
		{

			String id_ser = request.getParameter("id_ser");
			String nom_ser = request.getParameter("nom_ser");
			String cost_ser =  request.getParameter("cost_ser");
			String med_ser = request.getParameter("med_ser");
			request.setAttribute("id_ser", id_ser);
			request.setAttribute("nom_ser", nom_ser);
			request.setAttribute("cost_ser", cost_ser);
			request.setAttribute("med_ser", med_ser);
			request.getRequestDispatcher("editarServicio.jsp").forward(request, response);

		}
		else if (path.equalsIgnoreCase("/editarServicio.do"))
		{
			int id_ser = Integer.parseInt(request.getParameter("id_ser"));
			String nom_ser = request.getParameter("nom_ser");
			float cost_ser = Float.parseFloat( request.getParameter("cost_ser"));
			String med_ser = request.getParameter("med_ser");
			Servicio servicio = new Servicio(id_ser, nom_ser,cost_ser,med_ser);
			listaServicios = servicio.editar();
			request.setAttribute("listaServicios",listaServicios );
			request.getRequestDispatcher("pagServicios.jsp").forward(request, response);

		}
		//-------------------------------DETALLES PEDIDO-------------------------------
		else if(path.equalsIgnoreCase("/agregarDetallePed.do"))
		{
			//Servicio
			
			String info_ser = request.getParameter("sel_servicio");
			//REVISAR JS PARA REMOVER ESTO
			if(info_ser.equals("seleccionar") || request.getParameter("cant_dped").equals(""))
			{
			}
			else
			{
				Servicio servicio = new Servicio();
				servicio = servicio.buscar(info_ser);
				int idser_dped = servicio.getId_ser();
				float cant_dped = Float.parseFloat(request.getParameter("cant_dped"));
				float tot_dped = servicio.getCost_ser()*cant_dped;
				int id_dped = listaDetallesDePedido.size()+1;
				detallePedido dped = new detallePedido(id_dped,pedido.getId_ped(), idser_dped,cant_dped,tot_dped, servicio);
				listaDetallesDePedido.add(dped);
			}

			//Total pedido
			float tot_ped = 0;
			for(detallePedido dp : listaDetallesDePedido)
			{
				tot_ped += dp.getTot_dped();
			}
			pedido.setTot_ped(tot_ped);
			request.setAttribute("clientePedido", clientePedido);
			request.setAttribute("pedido", pedido);
			request.setAttribute("listaDetallesDePedido", listaDetallesDePedido);
			request.setAttribute("listaServicios", listaServicios);
			request.getRequestDispatcher("insertarPedido.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/eliminarDetalle.do"))
		{
			int id_dped = Integer.parseInt(request.getParameter("id_dped"));
			for (int i = 0; i<listaDetallesDePedido.size();i++)
			{
				if(listaDetallesDePedido.get(i).getId_dped()==id_dped)
				{
					pedido.setTot_ped(pedido.getTot_ped()-listaDetallesDePedido.get(i).getTot_dped());
					listaDetallesDePedido.remove(i);
				}
			}
			request.setAttribute("clientePedido", clientePedido);
			request.setAttribute("pedido", pedido);
			request.setAttribute("listaDetallesDePedido", listaDetallesDePedido);
			request.setAttribute("listaServicios", listaServicios);
			request.getRequestDispatcher("insertarPedido.jsp").forward(request, response);
			
		}
		//----------------------CRUD Pedidos-----------------------------
		else if(path.equalsIgnoreCase("/datosNuevoPedido.do"))
		{
			//Interfaz para el llenado del pedido
			listaDetallesDePedido.clear();
			//Cliente del pedido
			String id_cl =request.getParameter("id_cl");
			clientePedido = new Cliente();
			clientePedido = clientePedido.buscar(id_cl).get(0); 
			//Generar objeto pedido 
			pedido = new Pedido();
			pedido.setIdcl_ped(clientePedido.getId_cl());
			pedido.setId_ped(listaPedidos.size()+1); //Size para obtener el último y se suma uno
			request.setAttribute("listaServicios", listaServicios);
			request.setAttribute("clientePedido", clientePedido);
			request.setAttribute("pedido", pedido);
			request.getRequestDispatcher("insertarPedido.jsp").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/confirmarPedido.do"))
		{
			//Pagina de confirmación 
			request.setAttribute("clientePedido", clientePedido);
			request.setAttribute("pedido", pedido);
			request.setAttribute("listaDetallesDePedido", listaDetallesDePedido);
			request.setAttribute("listaServicios", listaServicios);
			request.getRequestDispatcher("confirmarPedido.jsp").forward(request, response);
			
		}
		
		else if(path.equalsIgnoreCase("/insertarPedido.do"))
		{
			//Se guarda el pedido en la BD
			listaPedidos = pedido.insertar();
			detallePedido dped = new detallePedido();
			dped.insertar(listaDetallesDePedido);
			request.getRequestDispatcher("paginaPedidos.do").forward(request, response);
		}
		
		else if(path.equalsIgnoreCase("/buscarPedido.do"))
		{
			//Buscar pedido
			String id_ped = request.getParameter("id_ped").trim();
			pedido.setId_ped(Integer.parseInt(id_ped));
			if(buscarPedido(id_ped)) {

			request.setAttribute("listaEstados", listaEstados);
			request.setAttribute("listaDetallesDePedido", listaDetallesDePedido);
			request.setAttribute("clientePedido", clientePedido);
			request.setAttribute("pedido", pedidoBuscado);
			request.getRequestDispatcher("editarPedido.jsp").forward(request, response);
			}
			else 
			{
				request.getRequestDispatcher("paginaPedidos.do").forward(request, response);
			}

		}
		else if(path.equalsIgnoreCase("/eliminarPedido.do"))
		{
			int id_ped = Integer.parseInt(request.getParameter("id_ped").trim());
			System.out.println(id_ped);
			detallePedido dped = new detallePedido();
			dped.setIdped_dped(id_ped);
			dped.eliminar();
			
			Pedido ped = new Pedido();
			ped.setId_ped(id_ped);
			listaPedidos = ped.eliminar();
			request.getRequestDispatcher("paginaPedidos.do").forward(request, response);
		}
		else if(path.equalsIgnoreCase("/editarPedido.do"))
		{
			
			String est_ped = request.getParameter("sel_estado");
			pedido.setEst_ped(est_ped);
			listaPedidos = pedido.editar();
			
			request.getRequestDispatcher("paginaPedidos.do").forward(request, response);
		}
		
		else if(path.equalsIgnoreCase("/buscarPedidoPub.do"))
		{
			int id_ped = Integer.parseInt(request.getParameter("id_ped"));
			String ape_cl = request.getParameter("ape_cl");
			//BUSCA EL PEDIDO
			for (Pedido ped : listaPedidos)
			{
				if(ped.getId_ped() == id_ped)
				{
					//VERIFICA QUE EL CLIENTE INGRESADO ES EL DEL PEDIDO
					for (Cliente cl : listaClientes)
					{
						if(ped.getIdcl_ped() ==cl.getId_cl() && cl.getApe_cl().equalsIgnoreCase(ape_cl))
						{
							//SI AMBOS COINCIDEN ENTONCES
							if(buscarPedido(String.valueOf(id_ped))) 
							{
								request.setAttribute("listaDetallesDePedido", listaDetallesDePedido);
								request.setAttribute("pedido", pedidoBuscado);
								request.getRequestDispatcher("mostrarPedidoPub.jsp").forward(request, response);
							}
						}
					}
				}
			}
			
		}
	//--------------------------FILTROS------------------------
		else if(path.equalsIgnoreCase("/filtroEstado.do"))
		{
			String est_ped = request.getParameter("sel_estado");
			listaPedidos = pedido.filtrarEstado(est_ped);
			request.setAttribute("listaEstados", listaEstados);
			request.setAttribute("listaPedidos", listaPedidos);
			request.getRequestDispatcher("paginaPedidos.jsp").forward(request, response);
			listaPedidos = pedido.buscarTodos();

			
		}
		else if(path.equalsIgnoreCase("/filtroCliente.do"))
		{
			String info_cl = request.getParameter("info_cl");
			List<Cliente> clienteBuscado = cliente.buscar(info_cl);
			
			if(!clienteBuscado.isEmpty())
			{
				List<Pedido> pedidosFiltrados = pedido.filtroCliente(info_cl);
				if(pedidosFiltrados.isEmpty())
				{
					request.setAttribute("listaPedidos", listaPedidos);
				}
				else 
				{
					request.setAttribute("listaPedidos", pedidosFiltrados);

				}
			}
			
			request.setAttribute("listaEstados", listaEstados);
			request.getRequestDispatcher("paginaPedidos.jsp").forward(request, response);
			listaPedidos = pedido.buscarTodos();
		}
	}
	
	protected boolean buscarPedido(String id_ped)
	{
		listaPedido = pedidoBuscado.buscar(id_ped);
		//Si no existe el pedido
		if(listaPedido.isEmpty())
		{
			return false;
		}
		else{
		pedido.setId_ped(Integer.parseInt(id_ped));
		//Buscar los detalles del pedido
		pedidoBuscado = listaPedido.get(0);
		detallePedido detalle = new detallePedido ();
		listaDetallesDePedido = detalle.buscar(id_ped);
		//Buscar el cliente del pedido
		clientePedido = new Cliente();
		clientePedido = clientePedido.buscarPorId(pedidoBuscado.getIdcl_ped());
		for(detallePedido dp : listaDetallesDePedido)
		{
			for(Servicio s : listaServicios)
			{
				if(dp.getIdser_dped()==s.getId_ser())
				{
					dp.agregarServicio(s);
				}
			}
		}
		return true;
		
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
