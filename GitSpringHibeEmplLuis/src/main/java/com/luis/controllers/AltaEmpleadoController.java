/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.model.Conocimientos;
import com.luis.model.Empleado;
import com.luis.model.Puesto;
import com.luis.model.viewforms.EmpleadoViewForm;
import com.luis.services.ManagerConocimientos;
import com.luis.services.ManagerEmpleados;
import com.luis.services.ManagerPuestos;

@Controller
@RequestMapping(value = "/adminaltaempleado.htm")
public class AltaEmpleadoController {

	static String path;

	// Sirver para inyectar automaticamente un objeto del tipo indicado
	// contenido en applicationcontext
	@Autowired
	private ManagerEmpleados managerEmpleados;

	@Autowired
	private ManagerPuestos managerPuestos;

	@Autowired
	private ManagerConocimientos managerConocimientos;

	public ManagerEmpleados getManagerEmpleados() {
		return managerEmpleados;
	}

	public void setManagerEmpleados(ManagerEmpleados managerEmpleados) {
		this.managerEmpleados = managerEmpleados;
	}

	public ManagerPuestos getManagerPuestos() {
		return managerPuestos;
	}

	public void setManagerPuestos(ManagerPuestos managerPuestos) {
		this.managerPuestos = managerPuestos;
	}

	public ManagerConocimientos getManagerConocimientos() {
		return managerConocimientos;
	}

	public void setManagerConocimientos(
			ManagerConocimientos managerConocimientos) {
		this.managerConocimientos = managerConocimientos;
	}

	@RequestMapping(method = RequestMethod.POST)
	// el bean empleadoviewform debe tener el constructor vacio
	// @Valid indica el el metodo pasa por validacion
	// @ModelAttribute("empleado") inidca el objeto que se va a validar
	protected String onSubmit(
			@Valid @ModelAttribute("empleado") EmpleadoViewForm empleado,
			BindingResult result, HttpServletRequest req) {

		if (result.hasErrors()) {
			Collection<Puesto> lp = managerPuestos.getAllPuesto();
			Map<Integer, String> mp = new HashMap<Integer, String>();

			for (Puesto puesto : lp) {
				mp.put(puesto.getIdPuesto(), puesto.getNombre());
			}

			req.setAttribute("puestos", mp);

			Collection<Conocimientos> lc = managerConocimientos
					.getAllConocimientos();

			Map<Integer, String> mc = new HashMap<Integer, String>();

			for (Conocimientos conocimiento : lc) {
				mc.put(conocimiento.getIdconocimientos(),
						conocimiento.getNombre());
			}
			req.setAttribute("conocimientos", mc);

			return "adminaltaempleado";
		}

		Date d = new Date();
		String ruta = d.getTime() + ".png";

		File dir = new File("/uploads");
		if (!dir.exists())
			dir.mkdir();

		System.out.println(dir.getAbsolutePath());

		File f = new File(dir, ruta);

		try {
			FileOutputStream fos = new FileOutputStream(f);
			byte[] datos = new byte[(int) empleado.getFoto().getSize()];
			empleado.getFoto().getInputStream().read(datos);
			fos.write(datos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Puesto p = new Puesto();
		p.setIdPuesto(empleado.getPuesto());

		Empleado em = new Empleado();
		em.setNombre(empleado.getNombre());
		em.setSalario(empleado.getSalario());
		em.setPuesto(p);
		em.setFechaAlta(empleado.getFechaAlta());

		em.setFoto("/uploads/" + ruta);

		Set<Conocimientos> sc = new HashSet<Conocimientos>();
		Conocimientos con;

		for (Integer idCon : empleado.getConocimientos()) {
			con = new Conocimientos();
			con.setIdconocimientos(idCon);
			sc.add(con);
		}

		em.setConocimientoses(sc);

		managerEmpleados.addEmpleado(em);

		return "redirect:/empleados.htm";
	}

	// ModelMap almacena los mapeos del modelo
	@RequestMapping(method = RequestMethod.GET)
	protected String formBackingObject(ModelMap model, HttpServletRequest req)
			throws Exception {

		path = req.getSession().getServletContext().getRealPath("/");

		EmpleadoViewForm empleado = new EmpleadoViewForm();
		empleado.setSalario(new Double(35000));
		model.addAttribute("empleado", empleado);

		Collection<Puesto> lp = managerPuestos.getAllPuesto();
		// La clave es al id y el value el nombre a mostrar
		Map<Integer, String> mp = new HashMap<Integer, String>();

		for (Puesto puesto : lp) {
			mp.put(puesto.getIdPuesto(), puesto.getNombre());
		}

		model.addAttribute("puestos", mp);

		Collection<Conocimientos> lc = managerConocimientos
				.getAllConocimientos();

		Map<Integer, String> mc = new HashMap<Integer, String>();

		for (Conocimientos conocimiento : lc) {
			mc.put(conocimiento.getIdconocimientos(), conocimiento.getNombre());
		}
		model.addAttribute("conocimientos", mc);

		return "adminaltaempleado";
	}
}
