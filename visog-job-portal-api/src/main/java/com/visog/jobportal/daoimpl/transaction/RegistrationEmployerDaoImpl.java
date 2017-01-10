package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.RegistrationEmployerDao;
import com.visog.jobportal.model.transaction.Users;

@Singleton
@Transactional
public class RegistrationEmployerDaoImpl extends AbstractDao implements RegistrationEmployerDao{
	
	private static final Logger logger = Logger.getLogger(RegistrationEmployerDaoImpl.class);

	/**
	 * This method returns the Industries data
	 */
	public List<Users> getEmployer() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Users> q = cb.createQuery(Users.class);
		Root<Users> c = q.from(Users.class);
	//	q.where(cb.equal(c.get("role"), "2556718a-37cc-40b4-9465-81ece73a6031"));
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	public Boolean isEmployerExists(String email) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Users> c = q.from(Users.class);
		//q.where(cb.equal(cb.lower(c.get("email")), email.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);
	}
	public Boolean isEmployerPhoneExists(String phone) {

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


	
	



