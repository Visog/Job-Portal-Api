package com.visog.jobportal.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.master.JobRoleDao;
import com.visog.jobportal.model.master.JobRole;

@Singleton
@Transactional
public class JobRoleDaoImpl extends AbstractDao implements JobRoleDao {

	private static final Logger logger = Logger.getLogger(JobRoleDaoImpl.class);

	/**
	 * @author Raghava
	 * This method returns the JobRoles data
	 */
	
	public List<JobRole> getJobRoles() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JobRole> q = cb.createQuery(JobRole.class);
		Root<JobRole> c = q.from(JobRole.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	/**
	 * @author Raghava
	 * This method deletes the JobRoles data
	 */
	/*
	public void delete(String id) {
		
		CriteriaBuilder criteriaBuilder  = em.getCriteriaBuilder();
		CriteriaDelete<JobRole> query = criteriaBuilder.createCriteriaDelete(JobRole.class);
		Root<JobRole> root = query.from(JobRole.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();
		
	}*/
}
