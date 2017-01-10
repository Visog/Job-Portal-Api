package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.RegistrationJobSeekerDao;
import com.visog.jobportal.model.transaction.Users;

@Singleton
@Transactional
public class RegistrationJobseekerDaoImpl extends AbstractDao implements RegistrationJobSeekerDao{
	
	private static final Logger logger = Logger.getLogger(RegistrationJobseekerDaoImpl.class);

	/**
	 * This method returns the Industries data
	 */
	public List<Users> getJobSeeker() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Users> q = cb.createQuery(Users.class);
		Root<Users> c = q.from(Users.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	public Boolean isJobSeekerExists(String email) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Users> c = q.from(Users.class);
		q.where(cb.equal(cb.lower(c.get("email")), email.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);
	}
	public Boolean isJobSeekerPhoneExists(String phone) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Users> c = q.from(Users.class);
		q.where(cb.equal(cb.lower(c.get("phone_no")), phone.toLowerCase()));
		/*  cb.and(
		          cb.gt(c.get("population"), p),
		          cb.lt(c.get("area"), a)
		      )*/
		
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);
	}

}


	
	



