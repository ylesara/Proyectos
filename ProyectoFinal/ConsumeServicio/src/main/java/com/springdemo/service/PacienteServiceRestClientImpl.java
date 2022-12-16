package com.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springdemo.model.Paciente;

@Service
public class PacienteServiceRestClientImpl implements PacienteService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public PacienteServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Paciente> getPacientes() {
		
		logger.info("***OBTENER LISTA DE PACIENTES DESDE EL SERVICE REST PACIENTE");
		logger.info("in getPacientes(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Paciente>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Paciente>>() {});

		// get the list of customers from response
		List<Paciente> pacientes = responseEntity.getBody();

		logger.info("in getPacientes(): pacientes" + pacientes);
		
		return pacientes;
	}

	@Override
	public Paciente getPaciente(int theId) {
		logger.info("***OBTENER UN PACIENTE DESDE EL SERVICE REST PACIENTE");

		logger.info("in getPaciente(): Calling REST API " + crmRestUrl);

		// make REST call
		Paciente thePaciente = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Paciente.class);

		logger.info("in savePaciente(): thePaciente=" + thePaciente);
		
		return thePaciente;
	}

	@Override
	public void savePaciente(Paciente thePaciente) {

		logger.info("in savePaciente(): Calling REST API " + crmRestUrl);
		
		int pacienteId = thePaciente.getId();

		// make REST call
		if (pacienteId == 0) {
			// add employee
			logger.info("***SALVAR UN PACIENTE DESDE EL SERVICE REST PACIENTE");

			restTemplate.postForEntity(crmRestUrl, thePaciente, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN PACIENTE DESDE EL SERVICE REST PACIENTE");

			restTemplate.put(crmRestUrl, thePaciente);
		}

		logger.info("in savePaciente(): success");	
	}

	@Override
	public void deletePaciente(int theId) {
		logger.info("***BORRAR UN CLIENTE DESDE EL SERVICE REST PACIENTE");

		logger.info("in deletePaciente(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deletePaciente(): deleted paciente theId=" + theId);
	}

}
