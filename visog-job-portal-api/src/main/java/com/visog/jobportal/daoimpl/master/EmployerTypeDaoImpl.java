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
import com.visog.jobportal.dao.master.EmployerTypeDao;
import com.visog.jobportal.model.master.EmployerType;
import com.visog.jobportal.model.master.Roles;




@Singleton
@Transactional
public class EmployerTypeDaoImpl extends AbstractDao implements EmployerTypeDao {

	private static final Logger logger = Logger.getLogger(EmployerTypeDaoImpl.class);

	/**
	 * This method returns the Roles data
	 */
	public List<EmployerType> getEmployerType() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployerType> q = cb.createQuery(EmployerType.class);
		Root<EmployerType> c = q.from(EmployerType.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}
	
	/*
	 * 
	 *  @author Divya Sharma
	 *  
	 * This method delete employer type record  
	 * 
	 * 
	 */

	public void delete(String id) {
		CriteriaBuilder criteriaBuilder  = em.getCriteriaBuilder();
		CriteriaDelete<EmployerType> query = criteriaBuilder.createCriteriaDelete(EmployerType.class);
		Root<EmployerType> root = query.from(EmployerType.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();
		
	}
	
	

}
