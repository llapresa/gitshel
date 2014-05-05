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

import com.llapresa.model.Puesto;
import com.llapresa.model.viewforms.PuestoViewForm;
import com.llapresa.services.ManagerPuestos;

@Controller
@RequestMapping(value = "/altapuesto.htm")
public class AltaPuestoController {

	@Autowired
	private ManagerPuestos managerPuestos;

	public ManagerPuestos getManagerPuestos() {
		return managerPuestos;
	}

	public void setManagerPuestos(ManagerPuestos managerPuestos) {
		this.managerPuestos = managerPuestos;
	}

	@RequestMapping(method = RequestMethod.POST)
	// el bean empleadoviewform debe tener el constructor vacio
	protected String onSubmit(PuestoViewForm puesto, BindingResult result) {

		if (result.hasErrors())
			return "altapuesto";

		Puesto pu = new Puesto();
		pu.setNombre(puesto.getNombre());

		managerPuestos.addPuesto(pu);

		return "redirect:/puestos.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected PuestoViewForm formBackingObject(HttpServletRequest req)
			throws Exception {

		PuestoViewForm puesto = new PuestoViewForm();
		req.setAttribute("puesto", puesto);
		return puesto;
	}

}
