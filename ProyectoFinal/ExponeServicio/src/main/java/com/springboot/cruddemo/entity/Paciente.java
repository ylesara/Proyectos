package com.springboot.cruddemo.entity;

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
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellido_Paterno")
	private String apellidoP;
	
	@Column(name="Apellido_Materno")
	private String apellidoM;
	
	@Column(name="Correo")
	private String correo;
	
}











