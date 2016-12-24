package com.visog.jobportal.daoimpl.master;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.master.EducationTypeDao;
import com.visog.jobportal.model.master.EducationType;



@Singleton
@Transactional
public class EducationTypeDaoImpl extends AbstractDao implements EducationTypeDao {

	
	private static final Logger logger = Logger.getLogger(EducationTypeDaoImpl.class);
	
	/**
	 * This method returns the Education types data
	 */
	
	public List<EducationType> getEducationTypes() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EducationType> q = cb.createQuery(EducationType.class);
		Root<EducationType> c = q.from(EducationType.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	/**
	 * This method deletes the Education types  data
	 */
	
	public void delete(String id) {
		CriteriaBuilder criteriaBuilder  = em.getCriteriaBuilder();
		CriteriaDelete<EducationType> query = criteriaBuilder.createCriteriaDelete(EducationType.class);
		Root<EducationType> root = query.from(EducationType.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();
		
	}
	
}
