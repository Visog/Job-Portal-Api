package com.visog.jobportal.daoimpl.common;

import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.constants.AppConstants;
import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.common.AppRoleId;
import com.visog.jobportal.model.master.Roles;

@Singleton
@Transactional
public class AppRoleIdImpl extends AbstractDao implements AppRoleId {

	private static final Logger logger = Logger.getLogger(AppRoleIdImpl.class);

	

	public Roles getRoleId(String roleName) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Roles> q = cb.createQuery(Roles.class);
			Root<Roles> c = q.from(Roles.class);
			q.where(cb.equal(cb.lower(c.get("name")), roleName));
			q.select(c);
			return em.createQuery(q).getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	
}
