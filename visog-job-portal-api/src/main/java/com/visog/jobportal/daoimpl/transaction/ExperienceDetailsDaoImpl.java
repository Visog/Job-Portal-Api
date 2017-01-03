package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.ExperienceDetailsDao;
import com.visog.jobportal.model.transaction.ExperienceDetails;
import com.visog.jobportal.model.transaction.Users;

public class ExperienceDetailsDaoImpl extends AbstractDao implements ExperienceDetailsDao{

	@Override
	public List<ExperienceDetails> getExperienceDetails() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ExperienceDetails> q = cb.createQuery(ExperienceDetails.class);
		Root<ExperienceDetails> c = q.from(ExperienceDetails.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
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
