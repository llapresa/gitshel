package com.luis.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.luis.model.Usuario;
import com.luis.services.ManagerAuth;

@Controller
@RequestMapping(value = "/login.htm")
public class LoginController {

	@Autowired
	private ManagerAuth manager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {

		Usuario usuario = new Usuario();

		return new ModelAndView("login", "usuario", usuario);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmint(Usuario usuario, BindingResult result,
			HttpServletRequest req) {

		// Aqui hacemos la validacion
		Usuario resultado = manager.validar(usuario.getLogin(),
				usuario.getPassword());

		if (resultado != null) {
			req.setAttribute("us", resultado);
			return "redirect: /guardarcontexto.htm";
		} else
			return "redirect: /empleados.htm";

	}
}
