package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PacienteDbUtil {

	private DataSource dataSource;

	public PacienteDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Paciente> getPacientes() throws Exception {
		
		List<Paciente> pacientes = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from paciente order by Apellido_Paterno";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("Nombre");
				String apellidoPaterno = myRs.getString("Apellido_Paterno");
				String apellidoMaterno = myRs.getString("Apellido_Materno");
				String correo = myRs.getString("Correo");
				
				// create new paciente object
				Paciente tempPaciente = new Paciente(id, nombre, apellidoPaterno, apellidoMaterno, correo);
				
				// add it to the list of pacientes
				pacientes.add(tempPaciente);				
			}
			
			return pacientes;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addPaciente(Paciente thePaciente) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into paciente "
					   + "(Nombre, Apellido_Paterno, Apellido_Materno, Correo) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, thePaciente.getNombre());
			myStmt.setString(2, thePaciente.getApellidoPaterno());
			myStmt.setString(3, thePaciente.getApellidoMaterno());
			myStmt.setString(4, thePaciente.getCorreo());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Paciente getPaciente(String thePacienteId) throws Exception {

		Paciente thePaciente = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int pacienteId;
		
		try {
			// convert paciente id to int
			pacienteId = Integer.parseInt(thePacienteId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from paciente where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, pacienteId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("Nombre");
				String apellidoPaterno = myRs.getString("Apellido_Paterno");
				String apellidoMaterno = myRs.getString("Apellido_Materno");
				String correo = myRs.getString("Correo");
				
				// use the pacienteId during construction
				thePaciente = new Paciente(pacienteId, nombre, apellidoPaterno, apellidoMaterno, correo);
			}
			else {
				throw new Exception("Could not find paciente id: " + pacienteId);
			}				
			
			return thePaciente;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updatePaciente(Paciente thePaciente) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update paciente "
						+ "set Nombre=?, Apellido_Paterno=?, Apellido_Materno=?, Correo=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, thePaciente.getNombre());
			myStmt.setString(2, thePaciente.getApellidoPaterno());
			myStmt.setString(3, thePaciente.getApellidoMaterno());
			myStmt.setString(4, thePaciente.getCorreo());
			myStmt.setInt(5, thePaciente.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deletePaciente(String thePacienteId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int pacienteId = Integer.parseInt(thePacienteId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from paciente where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, pacienteId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















