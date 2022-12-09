package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PacienteControllerServlet
 */
@WebServlet("/PacienteControllerServlet")
public class PacienteControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PacienteDbUtil pacienteDbUtil;
	
	@Resource(name="jdbc/web_paciente_tracker") //SE COMENTO PARA HACER USO DE JNDI
    private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		// create our paciente db util ... and pass in the conn pool / datasource
		try {
			//https://www.digitalocean.com/community/tutorials/tomcat-datasource-jndi-example-java
			//Context ctx = new InitialContext(); //USO DE JNDI
			//dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie"); //USO DE JNDI
			//System.out.println("Demo con JNDI, Datasource: "+dataSource);
			pacienteDbUtil = new PacienteDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing pacientes
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listPacientes(request, response);
				break;
				
			case "ADD":
				addPaciente(request, response);
				break;
				
			case "LOAD":
				loadPaciente(request, response);
				break;
				
			case "UPDATE":
				updatePaciente(request, response);
				break;
			
			case "DELETE":
				deletePaciente(request, response);
				break;
				
			default:
				listPacientes(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deletePaciente(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read paciente id from form data
		String thePacienteId = request.getParameter("pacienteId");
		
		// delete paciente from database
		pacienteDbUtil.deletePaciente(thePacienteId);
		
		// send them back to "list pacientes" page
		listPacientes(request, response);
	}

	private void updatePaciente(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read paciente info from form data
		int id = Integer.parseInt(request.getParameter("pacienteId"));
		String nombre = request.getParameter("Nombre");
		String apellidoPaterno = request.getParameter("Apellido_Paterno");
		String apellidoMaterno = request.getParameter("Apellido_Materno");
		String correo = request.getParameter("Correo");
		
		// create a new paciente object
		Paciente thePaciente = new Paciente(id, nombre, apellidoPaterno, apellidoMaterno, correo);
		
		// perform update on database
		pacienteDbUtil.updatePaciente(thePaciente);
		
		// send them back to the "list pacientes" page
		listPacientes(request, response);
		
	}

	private void loadPaciente(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read paciente id from form data
		String thePacienteId = request.getParameter("pacienteId");
		
		// get paciente from database (db util)
		Paciente thePaciente = pacienteDbUtil.getPaciente(thePacienteId);
		
		// place paciente in the request attribute
		request.setAttribute("THE_PACIENTE", thePaciente);
		
		// send to jsp page: update-paciente-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-paciente-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addPaciente(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read paciente info from form data
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String correo = request.getParameter("correo");		
		
		// create a new paciente object
		Paciente thePaciente = new Paciente(nombre, apellidoPaterno, apellidoMaterno, correo);
		
		// add the paciente to the database
		pacienteDbUtil.addPaciente(thePaciente);
				
		// send back to main page (the paciente list)
		listPacientes(request, response);
	}

	private void listPacientes(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get pacientes from db util
		List<Paciente> pacientes = pacienteDbUtil.getPacientes();
		
		for (Paciente s:pacientes) {
			System.out.println(s);
		}
		
		//pacientes.add(new Paciente(999, "Nombre","Apellido_Paterno", "Apellido_Materno", "email@gmail"));
		// add pacientes to the request
		request.setAttribute("LISTA_PACIENTES", pacientes);
		
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-pacientes.jsp");
		dispatcher.forward(request, response);
	}

}













