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
public class RegistrationEmployerDaoImpl extends AbstractDao implements RegistrationEmployerDao {

	private static final Logger logger = Logger.getLogger(RegistrationEmployerDaoImpl.class);
	

	public List<Users> getRegistrationEmployerDetails() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Users> q = cb.createQuery(Users.class);
		Root<Users> c = q.from(Users.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	
	}

	
	
}
