package com.springboot.cruddemo.dao;

import java.util.List;

import com.springboot.cruddemo.entity.Paciente;

public interface PacienteDAO {

	List<Paciente> findAll();
	
	Paciente findById(int theId);
	
	void save(Paciente thePaciente);
	
	void deleteById(int theId);
	
}
