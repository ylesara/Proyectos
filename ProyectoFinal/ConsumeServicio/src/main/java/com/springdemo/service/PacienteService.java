package com.springdemo.service;

import java.util.List;

import com.springdemo.model.Paciente;

public interface PacienteService {

	public List<Paciente> getPacientes();

	public void savePaciente(Paciente thePaciente);

	public Paciente getPaciente(int theId);

	public void deletePaciente(int theId);
	
}
