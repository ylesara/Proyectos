package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Paciente;

@Repository
public class PacienteDAOImpl implements PacienteDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Paciente> getPacientes() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Paciente> theQuery = 
				currentSession.createQuery("from Paciente order by nombre",
											Paciente.class);
		
		// execute query and get result list
		List<Paciente> pacientes = theQuery.getResultList();
				
		// return the results		
		return pacientes;
	}

	@Override
	public void savePaciente(Paciente thePaciente) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the paciente ... finally LOL
		currentSession.saveOrUpdate(thePaciente);
		
	}

	@Override
	public Paciente getPaciente(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Paciente thePaciente = currentSession.get(Paciente.class, theId);
		
		return thePaciente;
	}

	@Override
	public void deletePaciente(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Paciente where id=:pacienteId");
		theQuery.setParameter("pacienteId", theId);
		
		theQuery.executeUpdate();		
	}

}











