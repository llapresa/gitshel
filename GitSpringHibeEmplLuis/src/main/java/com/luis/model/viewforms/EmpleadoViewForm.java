/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.model.viewforms;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author alumno
 */
public class EmpleadoViewForm {

	private Integer idEmpleado;

	// @Pattern()
	// @Email
	@NotNull(message = "El nombre es obligatorio.")
	@Size(min = 4, max = 30)
	private String nombre;

	@NotNull(message = "El salario es obligatorio.")
	@Range(min = 9000, max = 60000)
	private Double salario;

	@NotNull(message = "Debes seleccionar un puesto.")
	@Range(min = 1, max = Integer.MAX_VALUE)
	private Integer puesto;

	private Date fechaAlta;

	@NotEmpty(message = "Debe seleccionar al menos un conocimiento.")
	private Integer[] conocimientos;

	private MultipartFile foto;

	public EmpleadoViewForm() {
		super();
		fechaAlta = new Date();
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getPuesto() {
		return puesto;
	}

	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Integer[] getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(Integer[] conocimientos) {
		this.conocimientos = conocimientos;
	}

	public MultipartFile getFoto() {
		return foto;
	}

	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}

}
