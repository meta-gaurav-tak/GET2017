/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.Shopping.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.Shopping.Product.Model.Product;

/**
 * The Class HibernateDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class HibernateDao<T, ID extends Serializable>
		implements
			AbstractDao<T, ID> {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** The model class. */
	private Class<T> modelClass;

	/**
	 * Gets the model class.
	 *
	 * @return the model class
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Instantiates a new hibernate dao.
	 *
	 * @param modelClass
	 *            the model class
	 */
	public HibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/*
	 * @see com.metacube.shoppingcart.dao.BaseDao#findAll()
	 */
	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#findOne(java.io.Serializable)
	 */
	@Override
	public T findOne(final ID primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		cr = cr.add(Restrictions.eq("id", primaryKey));
		return (T) cr.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(final ID primaryKey) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.shoppingcart.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(int primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		boolean result = true;
		T product = (T) cr.add(Restrictions.eq("id", primaryKey));
		session.delete(product);
		return result;

	}

	@Override
	public Boolean save(final T product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(product);
		return true;

	}
	@Override
	public Product edit(Product product,int primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();

		Product product1 = new Product();
		product1.setId(primaryKey);
		product1.setName(product.getName());
		product1.setPrice(product.getPrice());
		product1.setImageUrl(product.getImageUrl());
		session.update(product1);

		return product1;

	}
}
