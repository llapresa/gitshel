/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.llapresa.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.llapresa.model.Empleado;

/**
 * 
 * @author alumno
 */
@Transactional
public class ManagerEmpleados extends HibernateDaoSupport {

	public Empleado getEmpleado(Integer id) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// Debemos indicar la clase que queremos devolver y un objeto
		// serializable con la clave primaria
		Empleado em = (Empleado) ses.get(Empleado.class, id);

		return em;
	}

	public void addEmpleado(Empleado em) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.save(em);
		// ses.getTransaction().commit();
	}

	public void deleteEmpleado(Empleado em) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.delete(em);
		// ses.getTransaction().commit();
	}

	public void updateEmpleado(Empleado em) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.update(em);
		// ses.getTransaction().commit();
	}

	public Collection<Empleado> getAllEmpleados() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		// importante la mayuscula porque la query es sobre la clase no sobre la
		// DB
		Query q = ses.createQuery("from Empleado");

		List<Empleado> emple = q.list();

		return emple;
	}

	// 1ª forma de crear la query
	public Collection<Empleado> findEmpleadoByPuesto(int idPuesto) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		Query q = ses.createQuery("from Empleado where idPuesto = :puesto");
		q.setInteger("puesto", idPuesto);

		List<Empleado> l = q.list();

		return l;
	}

	// 2ª con este metodo utilizamos las named query definidas, pasamos el
	// nombre de la query y los parametros que necesitamos para utilizarla
	public Collection<Empleado> consultarDatos(String consulta,
			Map<String, Object> params) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		Query q = ses.getNamedQuery(consulta);

		for (String paramName : params.keySet()) {
			q.setParameter(paramName, params.get(paramName));
		}

		Collection<Empleado> l = q.list();

		return l;
	}
}
