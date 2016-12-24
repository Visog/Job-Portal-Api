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
import com.visog.jobportal.dao.master.GenderDao;
import com.visog.jobportal.model.master.Gender;


@Singleton
@Transactional
public class GenderDaoImpl extends AbstractDao implements GenderDao {
	
	private static final Logger logger = Logger.getLogger(GenderDaoImpl.class);

	/**
	 * This method returns the Gender data
	 */

	public List<Gender> getGenders() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Gender> q = cb.createQuery(Gender.class);
		Root<Gender> c = q.from(Gender.class);
		q.select(c);
		return em.createQuery(q).getResultList();	

	}
		/**
		 * This method deletes the Gender data
		 */
		
		public void delete(String id) {
			
			CriteriaBuilder criteriaBuilder  = em.getCriteriaBuilder();
			CriteriaDelete<Gender> query = criteriaBuilder.createCriteriaDelete(Gender.class);
			Root<Gender> root = query.from(Gender.class);
			query.where(root.get("id").in(id));

			em.createQuery(query).executeUpdate();
		}		
}
