package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.ProjectDetailsDao;
import com.visog.jobportal.model.transaction.ProjectDetails;
import com.visog.jobportal.model.transaction.Users;

@Singleton
@Transactional

public class ProjectDetailsDaoImpl extends AbstractDao implements ProjectDetailsDao{
private static final Logger logger = Logger.getLogger(ProjectDetailsDaoImpl.class);
	
	
	/**
	 * @author ShivaPrasad
	 */
	
	public List<ProjectDetails> getProjectDetailss() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProjectDetails> q = cb.createQuery(ProjectDetails.class);
		Root<ProjectDetails> c = q.from(ProjectDetails.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		

}


	
	public List<ProjectDetails> getProjectDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public Boolean isUsersExists(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public Boolean isUsersPhoneExists(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public Boolean isUsersLoginExists(String password, String email) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public List<Users> getIds(String password, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	}

