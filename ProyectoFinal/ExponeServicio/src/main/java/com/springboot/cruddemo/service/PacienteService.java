package com.springboot.cruddemo.service;

import java.util.List;

import com.springboot.cruddemo.entity.Paciente;

public interface PacienteService {

	public List<Paciente> findAll();
	
	public Paciente findById(int theId);
	
	public void save(Paciente thePaciente);
	
	public void deleteById(int theId);
	
}
