package com.visog.jobportal.daoimpl.common;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.common.EmployerJobSeekerDao;
import com.visog.jobportal.model.common.EmployerJobSeeker;

@Singleton
@Transactional
public class EmployerJobSeekerDaoImpl extends AbstractDao implements EmployerJobSeekerDao {

	private static final Logger logger = Logger.getLogger(EmployerJobSeekerDaoImpl.class);

	/**
	 * This method returns the EmployerJobseeker data
	 * 
	 * @Author=ravi
	 */

	
	
	public List<EmployerJobSeeker> getEmployerJobSeeker() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployerJobSeeker> q = cb.createQuery(EmployerJobSeeker.class);
		Root<EmployerJobSeeker> c = q.from(EmployerJobSeeker.class);
		q.select(c);

		return em.createQuery(q).getResultList();
	}
}
