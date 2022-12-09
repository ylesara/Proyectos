package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PacienteDAO;
import com.spring.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {

	// need to inject customer dao
	@Autowired
	private PacienteDAO pacienteDAO;
	
	@Override
	@Transactional
	public List<Paciente> getPacientes() {
		return pacienteDAO.getPacientes();
	}

	@Override
	@Transactional
	public void savePaciente(Paciente thePaciente) {

		pacienteDAO.savePaciente(thePaciente);
	}

	@Override
	@Transactional
	public Paciente getPaciente(int theId) {
		
		return pacienteDAO.getPaciente(theId);
	}

	@Override
	@Transactional
	public void deletePaciente(int theId) {
		
		pacienteDAO.deletePaciente(theId);
	}
}





