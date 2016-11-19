package com.jonatan.tutorial.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jonatan.tutorial.model.Provincia;
import com.jonatan.tutorial.model.User;

@Repository
public class ProvinciaDAOImpl implements ProvinciaDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addProvincia(Provincia p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Provincia añadida correctamente: " + p);
	}

	@Override
	public void updateProvincia(Provincia p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Provincia actualizada correctamente: " + p);
	}

	@SuppressWarnings("uncheked")
	@Override
	public List<Provincia> listProvincias() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Provincia> provinciasList = session.createQuery("from Provincia").list();
		for (Provincia p : provinciasList) {
			logger.info("Lista provincias ::" + p);
		}
		return provinciasList;
	}

	@Override
	public Provincia getProvinciaByCodigo(String codigo) {
		Session session = this.sessionFactory.getCurrentSession();
		Provincia p = (Provincia) session.load(Provincia.class, codigo);
		logger.info("Provincia cargada correctamente: " + p);

		return p;
	}

	@Override
	public void removeProvincia(String codigo) {
		Session session = this.sessionFactory.getCurrentSession();
		Provincia p = (Provincia) session.load(Provincia.class, codigo);
		if (p != null) {
			session.delete(p);
		}
		logger.info("Provincia borrada correctamete: " + p);
	}

}
