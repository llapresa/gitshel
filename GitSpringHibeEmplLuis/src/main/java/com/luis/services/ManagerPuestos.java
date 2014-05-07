/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luis.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.luis.model.Puesto;

/**
 * 
 * @author alumno
 */
@Transactional
public class ManagerPuestos extends HibernateDaoSupport {

	public Puesto getPuesto(Integer id) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// Debemos indicar la clase que queremos devolver y un objeto
		// serializable con la clave primaria
		Puesto p = (Puesto) ses.get(Puesto.class, id);

		return p;
	}

	public void addPuesto(Puesto p) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.save(p);
		// ses.getTransaction().commit();
	}

	public void deletePuesto(Puesto p) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.delete(p);
		// ses.getTransaction().commit();
	}

	public void updatePuesto(Puesto p) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.update(p);
		// ses.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Collection<Puesto> getAllPuesto() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		// importante la mayuscula porque la query es sobre la clase no sobre la
		// DB
		Query q = ses.createQuery("from Puesto");

		List<Puesto> puestos = q.list();

		return puestos;
	}
}
