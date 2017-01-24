package com.visog.jobportal.daoimpl.employer;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.employer.PostJobDao;
import com.visog.jobportal.model.employer.PostJob;

@Singleton
@Transactional
public class PostJobDaoImpl extends AbstractDao implements PostJobDao {
	
	private static final Logger logger = Logger.getLogger(PostJobDaoImpl.class);
	

	public List<PostJob> getPostJobs() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostJob> q = cb.createQuery(PostJob.class);
		Root<PostJob> c = q.from(PostJob.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	
}
