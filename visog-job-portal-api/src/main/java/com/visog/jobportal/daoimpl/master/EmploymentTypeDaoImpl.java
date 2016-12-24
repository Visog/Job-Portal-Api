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
import com.visog.jobportal.dao.master.EmploymentTypeDao;
import com.visog.jobportal.model.master.EmploymentType;




@Singleton
@Transactional
public class EmploymentTypeDaoImpl extends AbstractDao implements EmploymentTypeDao {

	private static final Logger logger = Logger.getLogger(EmploymentTypeDaoImpl.class);

	/*
	 * This method returns the Roles data
	 */
	public List<EmploymentType> getEmploymentType() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmploymentType> q = cb.createQuery(EmploymentType.class);
		Root<EmploymentType> c = q.from(EmploymentType.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}
	
	/*
	 * @author Divya Sharma
	 * 
	 * This method delete employment type record
	 * 
	 */

	public void delete(String id) {
		CriteriaBuilder criteriaBuilder  = em.getCriteriaBuilder();
		CriteriaDelete<EmploymentType> query = criteriaBuilder.createCriteriaDelete(EmploymentType.class);
		Root<EmploymentType> root = query.from(EmploymentType.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();
		
	}
	
	

}
