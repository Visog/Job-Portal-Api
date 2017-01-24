package com.visog.jobportal.daoimpl.jobseeker;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.jobseeker.JobSeekerDao;
import com.visog.jobportal.model.jobseeker.JobSeeker;



@Singleton
@Transactional
public class JobSeekerDaoImpl extends AbstractDao implements JobSeekerDao{
	
	private static final Logger logger = Logger.getLogger(JobSeekerDaoImpl.class);
	
	
	/**
	 * @author Raghava
	 */
	
	public List<JobSeeker> getJobSeekers() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JobSeeker> q = cb.createQuery(JobSeeker.class);
		Root<JobSeeker> c = q.from(JobSeeker.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

}
