package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.PacienteDAO;
import com.springboot.cruddemo.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {

	
	private PacienteDAO pacienteDAO;
	
	@Autowired
	public PacienteServiceImpl(@Qualifier("pacienteDAOJdbcImpl") PacienteDAO thePacienteDAO) {
		
		pacienteDAO = thePacienteDAO;
	}
	
	@Override
	@Transactional
	public List<Paciente> findAll() {
		return pacienteDAO.findAll();
	}

	@Override
	@Transactional
	public Paciente findById(int theId) {
		return pacienteDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Paciente thePaciente) {
		pacienteDAO.save(thePaciente);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		pacienteDAO.deleteById(theId);
	}

}






