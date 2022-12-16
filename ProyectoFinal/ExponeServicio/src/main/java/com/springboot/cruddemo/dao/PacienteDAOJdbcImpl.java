package com.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Paciente;

@Repository
public class PacienteDAOJdbcImpl implements PacienteDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Paciente> findAll() {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Paciente> listaPacientes = new ArrayList<>();

		String sql = "select * from Paciente";

		try (Connection myConn = dataSource.getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql);) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("Nombre");
				String apellidoP = myRs.getString("Apellido_Paterno");
				String apellidoM = myRs.getString("Apellido_Materno");
				String correo = myRs.getString("Correo");

				// create new student object
				Paciente tempPaciente = new Paciente(id, nombre, apellidoP, apellidoM, correo);

				// add it to the list of students
				listaPacientes.add(tempPaciente);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPacientes;
	}

	@Override
	public Paciente findById(int theId) {
		Paciente thePaciente = null;

		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = createPreparedStatement(myConn, theId);
			ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("Nombre");
				String apellidoP = myRs.getString("Apellido_Paterno");
				String apellidoM = myRs.getString("Apellido_Materno");
				String correo = myRs.getString("Correo");

				// use the studentId during construction
				thePaciente = new Paciente(theId, nombre, apellidoP, apellidoM, correo);
			} else {
				throw new SQLException("Could not find paciente id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thePaciente;
	}

	private PreparedStatement createPreparedStatement(Connection con, int pacienteId) throws SQLException {
		String sql = "select * from paciente where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pacienteId);
		return ps;
	}

	@Override
	public void save(Paciente thePaciente) {
		String sql = "";

		if (thePaciente.getId() == 0)
			sql = "insert into paciente (Nombre, Apellido_Paterno, Apellido_Materno, Correo) values (?, ?, ?,?)";
		else
			sql = "update paciente set Nombre=?, Apellido_Paterno=?, Apellido_Materno=?, Correo=? where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setString(1, thePaciente.getNombre());
			myStmt.setString(2, thePaciente.getApellidoP());
			myStmt.setString(3, thePaciente.getApellidoM());
			myStmt.setString(4, thePaciente.getCorreo());

			if (thePaciente.getId() != 0)
				myStmt.setInt(5, thePaciente.getId());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int theId) {
		
		try (Connection myConn = dataSource.getConnection(); 
			 PreparedStatement myStmt = myConn.prepareStatement("delete from paciente where id=?")) {

			myStmt.setInt(1, theId);

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}