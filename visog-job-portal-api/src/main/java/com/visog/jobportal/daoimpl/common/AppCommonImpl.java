package com.visog.jobportal.daoimpl.common;

import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.common.AppCommons;
import com.visog.jobportal.model.master.AddrerssType;
import com.visog.jobportal.model.master.Roles;

@Singleton
@Transactional
public class AppCommonImpl extends AbstractDao implements AppCommons {

	private static final Logger logger = Logger.getLogger(AppCommonImpl.class);

	

	public Roles getRoleId(String roleName) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Roles> q = cb.createQuery(Roles.class);
			Root<Roles> c = q.from(Roles.class);
			q.where(cb.equal(cb.lower(c.get("name")), roleName.toLowerCase()));
			q.select(c);
			return em.createQuery(q).getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}


	public AddrerssType getAddressId(String addressType) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<AddrerssType> q = cb.createQuery(AddrerssType.class);
			Root<AddrerssType> c = q.from(AddrerssType.class);
			q.where(cb.equal(cb.lower(c.get("name")), addressType.toLowerCase()));
			q.select(c);
			return em.createQuery(q).getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}


	public Status getStatusId(String status) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Status> q = cb.createQuery(Status.class);
			Root<Status> c = q.from(Status.class);
			q.where(cb.equal(cb.lower(c.get("name")), status.toLowerCase()));
			q.select(c);
			return em.createQuery(q).getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
		
	}

	
}
