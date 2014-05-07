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

import com.luis.model.Conocimientos;

/**
 * 
 * @author alumno
 */
@Transactional
public class ManagerConocimientos extends HibernateDaoSupport {

	public Conocimientos getConocimiento(Integer id) {

		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// Debemos indicar la clase que queremos devolver y un objeto
		// serializable con la clave primaria
		Conocimientos co = (Conocimientos) ses.get(Conocimientos.class, id);

		return co;
	}

	public void addConocimiento(Conocimientos co) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.save(co);
		// ses.getTransaction().commit();
	}

	public void deleteConocimiento(Conocimientos co) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.delete(co);
		// ses.getTransaction().commit();
	}

	public void updateConocimiento(Conocimientos co) {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();

		// ses.beginTransaction();
		ses.update(co);
		// ses.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Collection<Conocimientos> getAllConocimientos() {
		Session ses = getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		// importante la mayuscula porque la query es sobre la clase no sobre la
		// DB
		Query q = ses.createQuery("from Conocimientos");

		List<Conocimientos> cono = q.list();

		return cono;
	}

}
