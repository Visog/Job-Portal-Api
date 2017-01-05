package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.ExperienceDetailsDao;
import com.visog.jobportal.model.transaction.ExperienceDetails;


@Singleton
@Transactional
public class ExperienceDetailsDaoImpl extends AbstractDao implements ExperienceDetailsDao {

	private static final Logger logger = Logger.getLogger(ExperienceDetailsDaoImpl.class);
	
	public List<ExperienceDetails> getExperienceDetails() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ExperienceDetails> q = cb.createQuery(ExperienceDetails.class);
		Root<ExperienceDetails> c = q.from(ExperienceDetails.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}

}
