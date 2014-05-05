/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luis.model.Conocimientos;
import com.luis.services.ManagerConocimientos;

@Controller
public class ConocimientosController implements BeanFactoryAware {

	private ManagerConocimientos dao;

	@RequestMapping(value = "/conocimientos.htm")
	public ModelAndView handleRequest(HttpServletRequest hsr,
			HttpServletResponse hsr1) throws Exception {

		Collection<Conocimientos> c = dao.getAllConocimientos();

		Map<String, Object> datos;
		datos = new HashMap<String, Object>();

		datos.put("fecha", new Date());
		datos.put("conocimientos", c);

		return new ModelAndView("conocimientos", datos);
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		dao = (ManagerConocimientos) bf.getBean(ManagerConocimientos.class);
	}

}
