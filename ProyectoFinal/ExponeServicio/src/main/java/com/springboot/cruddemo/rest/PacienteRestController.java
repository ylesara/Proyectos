package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.entity.Paciente;
import com.springboot.cruddemo.service.PacienteService;

@RestController
@RequestMapping("/rest")
public class PacienteRestController {

	private PacienteService pacienteService;
	
	@Autowired
	public PacienteRestController(PacienteService thePacienteService) {
		pacienteService = thePacienteService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/pacientes")
	public List<Paciente> findAll() {
		return pacienteService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/pacientes/{pacienteId}")
	public Paciente getPaciente(@PathVariable int pacienteId) throws Exception {
		
		Paciente thePaciente = pacienteService.findById(pacienteId);
		
		if (thePaciente == null) {
			throw new Exception("Paciente id not found - " + pacienteId);
		}
		
		return thePaciente;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/pacientes")
	public Paciente addPaciente(@RequestBody Paciente thePaciente) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thePaciente.setId(0);
		
		pacienteService.save(thePaciente);
		
		return thePaciente;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/pacientes")
	public Paciente updatePaciente(@RequestBody Paciente thePaciente) {
		
		pacienteService.save(thePaciente);
		
		return thePaciente;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/pacientes/{pacienteId}")
	public String deletePaciente(@PathVariable int pacienteId) {
		
		Paciente tempPaciente = pacienteService.findById(pacienteId);
		
		// throw exception if null
		
		if (tempPaciente == null) {
			throw new RuntimeException("Paciente id not found - " + pacienteId);
		}
		
		pacienteService.deleteById(pacienteId);
		
		return "Deleted paciente id - " + pacienteId;
	}
	
}










