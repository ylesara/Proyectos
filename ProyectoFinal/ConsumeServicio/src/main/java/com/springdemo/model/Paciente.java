package com.springdemo.model;

import javax.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidoP")
	private String apellidoP;
	
	@Column(name="apellidoM")
	private String apellidoM;
	
	@Column(name="correo")
	private String correo;
	
}

















