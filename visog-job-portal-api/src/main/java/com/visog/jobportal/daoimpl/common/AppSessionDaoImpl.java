package com.visog.jobportal.daoimpl.common;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.common.AppSessionDao;
import com.visog.jobportal.model.common.AppSession;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.master.AddrerssType;

@Singleton
@Transactional
public class AppSessionDaoImpl extends AbstractDao implements AppSessionDao {

	private static final Logger logger = Logger.getLogger(AppSessionDaoImpl.class);

	public List<AppSession> getAppSession() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AppSession> q = cb.createQuery(AppSession.class);
		Root<AppSession> c = q.from(AppSession.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	
public AppSession getDetails(String userid) {

	try {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AppSession> q = cb.createQuery(AppSession.class);
		Root<AppSession> c = q.from(AppSession.class);
		q.where(cb.equal(cb.lower(c.get("user")), userid.toLowerCase()));
		q.select(c);
		return em.createQuery(q).getSingleResult();
	} catch (NoResultException | NonUniqueResultException e) {
		return null;
	}
}
}
