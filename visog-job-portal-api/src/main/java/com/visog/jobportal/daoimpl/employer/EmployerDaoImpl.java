package com.visog.jobportal.daoimpl.employer;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.employer.EmployerDao;
import com.visog.jobportal.model.employer.Employer;


@Singleton
@Transactional
public class EmployerDaoImpl extends AbstractDao implements EmployerDao {

	private static final Logger logger = Logger.getLogger(EmployerDaoImpl.class);

	/**
	 * @author Raghava
	 */

	public List<Employer> getEmployers() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employer> q = cb.createQuery(Employer.class);
		Root<Employer> c = q.from(Employer.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

}
