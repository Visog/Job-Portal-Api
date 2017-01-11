package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.constants.AppConstants;
import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.AppRoleId;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.model.transaction.Users;

import javax.persistence.criteria.Root;

@Singleton
@Transactional
public class AppRoleIdImpl extends AbstractDao implements AppRoleId {

	private static final Logger logger = Logger.getLogger(AppRoleIdImpl.class);

	public List<Roles> getJobSeekerRoleId() {
		
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Roles> q = cb.createQuery(Roles.class);
		Root<Roles> c = q.from(Roles.class);
		q.where(cb.equal(cb.lower(c.get("name")), AppConstants.jobSeekerName));
		q.select(c);
		return em.createQuery(q).getResultList();
		
		   /*return em.createQuery(
			        "SELECT id FROM Roles  WHERE name LIKE :name")
			        .setParameter("name", AppConstants.jobSeekerName)
			        .getResultList();*/
		
		/*String id="";
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Roles> q = cb.createQuery(Roles.class);
		Root<Roles> c = q.from(Roles.class);*/
		//q.select(cb.array(c.get("name"), AppConstants.jobSeekerName));
		//q.where(cb.equal(cb.lower(c.get("name")), AppConstants.jobSeekerName));
		/*List<Tuple> results = em.createQuery(q).getResultList();
		for (Tuple tuple : results) {
			
			System.out.println("ID: " + tuple.get(0));
			id=(String) tuple.get(0);
			
		}*/
		//logger.info("JobSeeker created successfully : " + user.getId());
		//return em.createQuery(q).getResultList();

		/*
		 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Long> q =
		 * cb.createQuery(Long.class); Root<Roles> c = q.from(Roles.class);
		 * q.where(cb.equal(cb.lower(c.get("name")),AppConstants.jobSeekerName.
		 * toLowerCase())); q.select(c); return roleId;
		 */

		/*
		 * Query query = em.createQuery("SELECT id FROM Roles WHERE id = :id");
		 * query.setParameter("name",
		 * AppConstants.jobSeekerName).executeUpdate();
		 */

		/*
		 * return null;
		 * 
		 * /*String id=""; TypedQuery<Object[]> query = em.createQuery(
		 * "SELECT id FROM ROLES where name='"+AppConstants.jobSeekerName+"'",
		 * Object[].class); List<Object[]> results = query.getResultList(); for
		 * (Object[] result : results) { System.out.println("id: " + result[0]
		 * ); logger.info("id: " + result[0]); id=(String) result[0]; }
		 * 
		 * return id;
		 */

	}

	public String getEmployerRoleId() {
		return null;
	}

	public String getAdminRoleId() {
		return null;
	}

}
