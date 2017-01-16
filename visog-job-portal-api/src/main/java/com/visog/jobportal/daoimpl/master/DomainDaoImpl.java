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
import com.visog.jobportal.dao.master.DomainDao;
import com.visog.jobportal.model.master.Domains;

@Singleton
@Transactional
public class DomainDaoImpl extends AbstractDao implements DomainDao {

	private static final Logger logger = Logger.getLogger(DomainDaoImpl.class);

	/**
	 * @author Raghava
	 *  This method returns the Roles data
	 */

	public List<Domains> getDomains() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Domains> q = cb.createQuery(Domains.class);
		Root<Domains> c = q.from(Domains.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	

}
