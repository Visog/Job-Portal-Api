package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.ProjectDetailsDao;
import com.visog.jobportal.model.transaction.ProjectDetails;
import com.visog.jobportal.model.transaction.Users;

/**
 * @author ShivaPrasad
 */
@Singleton
@Transactional
public class ProjectDetailsDaoImpl extends AbstractDao implements ProjectDetailsDao {

	private static final Logger logger = Logger.getLogger(ProjectDetailsDaoImpl.class);

	/* 
	 */

	public List<ProjectDetails> getProjectDetails() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProjectDetails> q = cb.createQuery(ProjectDetails.class);
		Root<ProjectDetails> c = q.from(ProjectDetails.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

}
