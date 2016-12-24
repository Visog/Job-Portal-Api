package com.visog.jobportal.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.master.CityDao;
import com.visog.jobportal.model.master.City;

@Singleton
@Transactional
public class CityDaoImpl extends AbstractDao implements CityDao {

	private static final Logger logger = Logger.getLogger(CityDaoImpl.class);

	/**
	 * This method returns the City data
	 */

	public List<City> getCities() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<City> q = cb.createQuery(City.class);
		Root<City> c = q.from(City.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	public Boolean isCityExists(String name) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<City> c = q.from(City.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);
	}
}
