/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.model.viewforms;

import java.util.Date;

/**
 * 
 * @author alumno
 */
public class EmpleadoViewForm {

	private String nombre;
	private Double salario;
	private Integer puesto;
	private Date fechaAlta;
	private Integer[] conocimientos;

	public EmpleadoViewForm() {
		super();
		fechaAlta = new Date();
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

}
