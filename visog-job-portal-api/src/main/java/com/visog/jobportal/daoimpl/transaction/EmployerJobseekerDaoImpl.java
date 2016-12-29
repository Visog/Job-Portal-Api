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
import com.visog.jobportal.dao.transaction.EmployerJobseekerDao;
import com.visog.jobportal.model.transaction.EmployerJobseeker;

@Singleton
@Transactional
public class EmployerJobseekerDaoImpl extends AbstractDao implements EmployerJobseekerDao{
	
	private static final Logger logger = Logger.getLogger(EmployerJobseekerDaoImpl.class);


	/**
	 * This method returns the EmployerJobseeker data
	 *@Author=ravi
	 */
	
	public List<EmployerJobseeker> getEmployerjobseekers() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployerJobseeker> q=cb.createQuery(EmployerJobseeker.class);
		Root<EmployerJobseeker> c=q.from(EmployerJobseeker.class);
		q.select(c);
		
		return em.createQuery(q).getResultList();
	}
	
	/**
	 * This method delete the EmployerJobseeker data
	 
	 */
	public void delete(String id){
		
		CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
		CriteriaDelete<EmployerJobseeker> query=criteriaBuilder.createCriteriaDelete(EmployerJobseeker.class);
		Root<EmployerJobseeker> root=query.from(EmployerJobseeker.class);
		query.where(root.get("id").in(id));
		em.createQuery(query).executeUpdate();
		
	}

}
