package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Paciente;
import com.spring.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	// need to inject our paciente service
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/list")
	public String listPacientes(Model theModel) {
		
		// get paciente from the service
		List<Paciente> thePacientes = pacienteService.getPacientes();
				
		// add the pacientes to the model
		theModel.addAttribute("pacientes", thePacientes);
		
		return "list-pacientes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Paciente thePaciente = new Paciente();
		
		theModel.addAttribute("paciente", thePaciente);
		
		return "paciente-form";
	}
	
	@PostMapping("/savePaciente")
	public String savePaciente(@ModelAttribute("paciente") Paciente thePaciente) {
		
		// save the paciente using our service
		pacienteService.savePaciente(thePaciente);	
		
		return "redirect:/paciente/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pacienteId") int theId,
									Model theModel) {
		
		// get the paciente from our service
		Paciente thePaciente = pacienteService.getPaciente(theId);	
		
		// set paciente as a model attribute to pre-populate the form
		theModel.addAttribute("paciente", thePaciente);
		
		// send over to our form		
		return "paciente-form";
	}
	
	@GetMapping("/delete")
	public String deletePaciente(@RequestParam("pacienteId") int theId) {
		
		// delete the paciente
		pacienteService.deletePaciente(theId);
		
		return "redirect:/paciente/list";
	}
}










