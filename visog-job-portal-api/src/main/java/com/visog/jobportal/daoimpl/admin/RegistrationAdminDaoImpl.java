package com.visog.jobportal.daoimpl.admin;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.admin.RegistrationAdminDao;
import com.visog.jobportal.model.common.Users;

@Singleton
@Transactional
public class RegistrationAdminDaoImpl extends AbstractDao implements RegistrationAdminDao {

	private static final Logger logger = Logger.getLogger(RegistrationAdminDaoImpl.class);

	/**
	 * This method returns the Industries data
	 */
	public List<Users> getAdmin() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Users> q = cb.createQuery(Users.class);
		Root<Users> c = q.from(Users.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	public Boolean isAdminExists(String email) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Users> c = q.from(Users.class);
		q.where(cb.equal(cb.lower(c.get("email")), email.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);
	}

	public Boolean isAdminPhoneExists(String phone) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<Users> c = q.from(Users.class);
		q.where(cb.equal(c.get("phone"), phone));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);
	}

}
