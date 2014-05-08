package com.luis.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luis.model.Empleado;
import com.luis.model.Puesto;
import com.luis.model.viewforms.EmpleadoViewForm;
import com.luis.services.ManagerEmpleados;

@Controller
@RequestMapping(value = "/empleado")
public class EmpleadosRest {

	@Autowired
	private ManagerEmpleados managerEmpleados;

	public ManagerEmpleados getManagerEmpleados() {
		return managerEmpleados;
	}

	public void setManagerEmpleados(ManagerEmpleados managerEmpleados) {
		this.managerEmpleados = managerEmpleados;
	}

	// Devolvemos un viewform y no la clase creada con Hibernate porque
	// al serializar las relacciones no funciona
	// @ResponseBody hace que se devuelva un Json
	// value = "/{id}" Indicamos que añadiendo a la url / mas una variable (se
	// indica {})
	// '.../empleado/5'
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody
	EmpleadoViewForm empleado(@PathVariable int id) {// Le indicamos que el id
														// es el indicado en la
														// variable

		Empleado emple = managerEmpleados.getEmpleado(id, true);

		EmpleadoViewForm evf = new EmpleadoViewForm();
		evf.setIdEmpleado(emple.getIdEmpleado());
		evf.setNombre(emple.getNombre());
		evf.setFechaAlta(emple.getFechaAlta());
		evf.setPuesto(emple.getPuesto().getIdPuesto());

		return evf;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<EmpleadoViewForm> empleado() {

		Collection<Empleado> emple = managerEmpleados.getAllEmpleados();
		List<EmpleadoViewForm> l = new ArrayList<EmpleadoViewForm>();

		for (Empleado e : emple) {
			EmpleadoViewForm evf = new EmpleadoViewForm();
			evf.setIdEmpleado(e.getIdEmpleado());
			evf.setNombre(e.getNombre());
			evf.setFechaAlta(e.getFechaAlta());
			evf.setPuesto(e.getPuesto().getIdPuesto());

			l.add(evf);
		}

		return l;
	}

	// pasamos un objeto Json y
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	EmpleadoViewForm alta(@RequestBody EmpleadoViewForm emple) {
		Puesto p = new Puesto();
		p.setIdPuesto(emple.getPuesto());

		Empleado e = new Empleado();
		e.setNombre(emple.getNombre());
		e.setPuesto(p);
		e.setSalario(e.getSalario());
		e.setFechaAlta(new Date());
		managerEmpleados.addEmpleado(e);

		emple.setIdEmpleado(e.getIdEmpleado());
		emple.setFechaAlta(e.getFechaAlta());

		return emple;
	}

	// pasamos un objeto Json y
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody
	EmpleadoViewForm borrar(@RequestBody EmpleadoViewForm emple) {

		Empleado e = new Empleado();
		e.setIdEmpleado(emple.getIdEmpleado());
		managerEmpleados.deleteEmpleado(e);

		return emple;
	}

}
