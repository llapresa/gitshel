package com.llapresa.model;

// Generated 25-abr-2014 21:04:13 by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;

/**
 * Conocimientos generated by hbm2java
 */
public class Conocimientos implements java.io.Serializable {

	private Integer idconocimientos;
	private String nombre;
	private Set empleados = new HashSet(0);

	public Conocimientos() {
	}

	public Conocimientos(String nombre) {
		this.nombre = nombre;
	}

	public Conocimientos(String nombre, Set empleados) {
		this.nombre = nombre;
		this.empleados = empleados;
	}

	public Integer getIdconocimientos() {
		return this.idconocimientos;
	}

	public void setIdconocimientos(Integer idconocimientos) {
		this.idconocimientos = idconocimientos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set empleados) {
		this.empleados = empleados;
	}

}
