package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.EducationDetailsDao;
import com.visog.jobportal.model.transaction.EducationDetails;

@Singleton
@Transactional
public class EducationDetailsDaoImpl extends AbstractDao implements EducationDetailsDao{
	
	private static final Logger logger = Logger.getLogger(EducationDetailsDaoImpl.class);


	/**
	 * This method returns the EducationDetailsDao data
	 *@Author=Bala
	 */
	
	public List<EducationDetails> getEducationDetails() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EducationDetails> q=cb.createQuery(EducationDetails.class);
		Root<EducationDetails> c=q.from(EducationDetails.class);
		q.select(c);
		
		return em.createQuery(q).getResultList();
	}
	
	/**
	 * This method delete the EmployerJobseeker data
	 
	 */
	public void delete(String id){
		
		CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
		CriteriaDelete<EducationDetails> query=criteriaBuilder.createCriteriaDelete(EducationDetails.class);
		Root<EducationDetails> root=query.from(EducationDetails.class);
		query.where(root.get("id").in(id));
		em.createQuery(query).executeUpdate();
		
	}

	@Override
	public List<EducationDetailsDao> getEducationDetailsDao() {
		// TODO Auto-generated method stub
		return null;
	}

}