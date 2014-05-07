package com.luis.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping(value = "/modificarempleado.htm")
public class ModificarEmpleadoController {

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
	protected String onSubmit(EmpleadoViewForm empleado, BindingResult result) {

		if (result.hasErrors())
			return "modificarempleado";

		Puesto p = new Puesto();
		p.setIdPuesto(empleado.getPuesto());

		Empleado em = new Empleado();
		em.setNombre(empleado.getNombre());
		em.setSalario(empleado.getSalario());
		em.setPuesto(p);
		em.setFechaAlta(empleado.getFechaAlta());

		Set<Conocimientos> sc = new HashSet<Conocimientos>();
		Conocimientos con;

		for (Integer idCon : empleado.getConocimientos()) {
			con = new Conocimientos();
			con.setIdconocimientos(idCon);
			sc.add(con);
		}

		em.setConocimientoses(sc);
		em.setIdEmpleado(empleado.getIdEmpleado());

		managerEmpleados.updateEmpleado(em);

		return "redirect:/empleados.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected EmpleadoViewForm formBackingObject(HttpServletRequest req)
			throws Exception {

		Integer id = Integer.parseInt(req.getParameter("id"));
		Empleado emp = managerEmpleados.getEmpleado(id, false);

		EmpleadoViewForm empleado = new EmpleadoViewForm();
		empleado.setSalario(emp.getSalario());
		empleado.setNombre(emp.getNombre());
		empleado.setFechaAlta(emp.getFechaAlta());
		empleado.setPuesto(emp.getPuesto().getIdPuesto());
		empleado.setIdEmpleado(emp.getIdEmpleado());

		Integer[] conom = new Integer[emp.getConocimientoses().size()];

		int pos = 0;
		for (Conocimientos con : emp.getConocimientoses()) {
			conom[pos++] = con.getIdconocimientos();
		}

		empleado.setConocimientos(conom);

		req.setAttribute("empleado", empleado);

		Collection<Puesto> lp = managerPuestos.getAllPuesto();
		// La clave es al id y el value el nombre a mostrar
		Map<Integer, String> mp = new HashMap<Integer, String>();

		for (Puesto puesto : lp) {
			mp.put(puesto.getIdPuesto(), puesto.getNombre());
		}

		req.setAttribute("puestos", mp);

		Collection<Conocimientos> lc = managerConocimientos
				.getAllConocimientos();

		Map<Integer, String> mc = new HashMap<Integer, String>();

		for (Conocimientos conocimiento : lc) {
			mc.put(conocimiento.getIdconocimientos(), conocimiento.getNombre());
		}
		req.setAttribute("conocimientos", mc);

		return empleado;
	}
}
