package com.luis.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
			// Lista de privilegios que tiene un usuario
			List<GrantedAuthority> perm = new ArrayList<GrantedAuthority>();
			perm.add(new SimpleGrantedAuthority(resultado.getRol().getRol()));

			// Creamos el token de autenticacion para que cada vez que sea
			// requerido
			// el sistema recurra al mismo
			Authentication auth = new UsernamePasswordAuthenticationToken(
					resultado.getLogin(), resultado.getPassword(), perm);

			// Almacenamos la autenticacon en el contexto de seguridad
			SecurityContextHolder.getContext().setAuthentication(auth);

			return "welcome";// "redirect:/adminaltaempleado.htm";
		} else
			return "login";

	}
}
