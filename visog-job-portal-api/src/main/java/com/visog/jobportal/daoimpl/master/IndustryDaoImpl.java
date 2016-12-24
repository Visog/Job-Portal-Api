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
import com.visog.jobportal.dao.master.IndustryDao;
import com.visog.jobportal.model.master.Industry;

@Singleton
@Transactional
public class IndustryDaoImpl extends AbstractDao implements IndustryDao{
	
	private static final Logger logger = Logger.getLogger(IndustryDaoImpl.class);

	/**
	 * This method returns the Industries data
	 */
	public List<Industry> getIndustries() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Industry> q = cb.createQuery(Industry.class);
		Root<Industry> c = q.from(Industry.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}

	public void delete(String id) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<Industry> query = criteriaBuilder.createCriteriaDelete(Industry.class);
		Root<Industry> root = query.from(Industry.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();
		
	}
	
	

}



