package com.visog.jobportal.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.master.CountryDao;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.Roles;

@Singleton
@Transactional
public class CountryDaoImpl extends AbstractDao implements CountryDao {

	private static final Logger logger = Logger.getLogger(CountryDaoImpl.class);

	public List<Country> getCountries() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> q = cb.createQuery(Country.class);
		Root<Country> c = q.from(Country.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}	
	
	
	public Boolean isCountryExists(String name) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Country> c = q.from(Country.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}
}