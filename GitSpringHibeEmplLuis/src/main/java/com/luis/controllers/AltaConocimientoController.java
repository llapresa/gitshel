/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.model.Conocimientos;
import com.luis.model.viewforms.ConocimientoViewForm;
import com.luis.services.ManagerConocimientos;

@Controller
@RequestMapping(value = "/adminaltaconocimiento.htm")
public class AltaConocimientoController {

	@Autowired
	private ManagerConocimientos managerConocimientos;

	public ManagerConocimientos getManagerConocimientos() {
		return managerConocimientos;
	}

	public void setManagerConocimientos(
			ManagerConocimientos managerConocimientos) {
		this.managerConocimientos = managerConocimientos;
	}

	@RequestMapping(method = RequestMethod.POST)
	// el bean empleadoviewform debe tener el constructor vacio
	protected String onSubmit(ConocimientoViewForm conocimiento,
			BindingResult result) {

		if (result.hasErrors())
			return "altaconocimiento";

		// Puesto p = new Puesto();
		// p.setIdPuesto(1);
		Conocimientos co = new Conocimientos();
		co.setNombre(conocimiento.getNombre());

		managerConocimientos.addConocimiento(co);

		return "redirect:/conocimientos.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ConocimientoViewForm formBackingObject(HttpServletRequest req)
			throws Exception {

		ConocimientoViewForm conocimiento = new ConocimientoViewForm();
		req.setAttribute("conocimiento", conocimiento);
		return conocimiento;
	}
}
