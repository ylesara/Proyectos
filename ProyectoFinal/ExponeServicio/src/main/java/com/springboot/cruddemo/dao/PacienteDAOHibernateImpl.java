package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Paciente;

@Repository
public class PacienteDAOHibernateImpl implements PacienteDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public PacienteDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Paciente> findAll() {
		System.out.println("PacienteDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Paciente> theQuery =
				currentSession.createQuery("from Paciente", Paciente.class);
		
		// execute query and get result list
		List<Paciente> pacientes = theQuery.getResultList();
		
		// return the results		
		return pacientes;
	}


	@Override
	public Paciente findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Paciente thePaciente =
				currentSession.get(Paciente.class, theId);
		
		// return the employee
		return thePaciente;
	}


	@Override
	public void save(Paciente thePaciente) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(thePaciente);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Paciente where id=:pacienteId");
		
		theQuery.setParameter("pacienteId", theId);
		
		theQuery.executeUpdate();
	}

}







