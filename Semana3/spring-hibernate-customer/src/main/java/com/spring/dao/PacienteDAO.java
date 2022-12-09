package com.spring.dao;

import java.util.List;

import com.spring.entity.Paciente;

public interface PacienteDAO {

	public List<Paciente> getPacientes();

	public void savePaciente(Paciente thePaciente);

	public Paciente getPaciente(int theId);

	public void deletePaciente(int theId);
	
}
