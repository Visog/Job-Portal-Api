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
import com.visog.jobportal.dao.master.CurrencyDao;
import com.visog.jobportal.model.master.Currency;




@Singleton
@Transactional
public class CurrencyDaoImpl extends AbstractDao implements CurrencyDao {

	private static final Logger logger = Logger.getLogger(CurrencyDaoImpl.class);

	/**
	 * This method returns the Currencies data
	 */
	public List<Currency> getCurrencies() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Currency> q = cb.createQuery(Currency.class);
		Root<Currency> c = q.from(Currency.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	public void delete(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<Currency> query = criteriaBuilder.createCriteriaDelete(Currency.class);
		Root<Currency> root = query.from(Currency.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();

	}

}

	
	


