package com.jonatan.tutorial.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jonatan.tutorial.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("Usuario añadido correctamente: " + u);
	}

	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("Usuario actualizado correctamente: " + u);
	}

	@SuppressWarnings("uncheked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for (User u : usersList) {
			logger.info("Lista usuario ::" + u);
		}
		return usersList;
	}

	@Override
	public User getUserByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, name);
		logger.info("Usuario cargado correctamente: " + u);

		return u;
	}

	@Override
	public void removeUser(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, name);
		if (u != null) {
			session.delete(u);
		}
		logger.info("Usuario borrado correctamete: " + u);
	}

}
