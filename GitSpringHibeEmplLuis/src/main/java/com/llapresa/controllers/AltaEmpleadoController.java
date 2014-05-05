/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.llapresa.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.llapresa.model.Empleado;
import com.llapresa.model.Puesto;
import com.llapresa.model.viewforms.EmpleadoViewForm;
import com.llapresa.services.ManagerEmpleados;

@Controller
@RequestMapping(value = "/altaempleado.htm")
public class AltaEmpleadoController {

	// Sirver para inyectar automaticamente un objeto del tipo indicado
	// contenido en applicationcontext
	@Autowired
	private ManagerEmpleados managerEmpleados;

	public ManagerEmpleados getManagerEmpleados() {
		return managerEmpleados;
	}

	public void setManagerEmpleados(ManagerEmpleados managerEmpleados) {
		this.managerEmpleados = managerEmpleados;
	}

	@RequestMapping(method = RequestMethod.POST)
	// el bean empleadoviewform debe tener el constructor vacio
	protected String onSubmit(EmpleadoViewForm empleado, BindingResult result) {

		if (result.hasErrors())
			return "altaempleado";

		Puesto p = new Puesto();
		p.setIdPuesto(1);
		Empleado em = new Empleado();
		em.setNombre(empleado.getNombre());
		em.setSalario(empleado.getSalario());
		em.setPuesto(p);

		managerEmpleados.addEmpleado(em);

		return "redirect:/empleados.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected EmpleadoViewForm formBackingObject(HttpServletRequest req)
			throws Exception {

		EmpleadoViewForm empleado = new EmpleadoViewForm();
		empleado.setSalario(new Double(35000));
		req.setAttribute("empleado", empleado);
		return empleado;
	}
}
