package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.jpa.criteria.compile.CriteriaQueryTypeQueryAdapter;
import org.jboss.resteasy.logging.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.LanguageKnownDao;
import com.visog.jobportal.model.transaction.LanguageKnown;

@Singleton
@Transactional
public class LanguageKnownDaoImpl extends AbstractDao implements LanguageKnownDao{
	 private static final Logger logger=Logger.getLogger(LanguageKnownDaoImpl.class);
		
	/**
	 * This method returns the Files data
	 *@Author=ravi
	 */
	public List<LanguageKnown> getLanguagesKnown() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LanguageKnown> q=cb.createQuery(LanguageKnown.class);
		Root<LanguageKnown> c=q.from(LanguageKnown.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
	}
	
	/**
	 * This method delete the Files data
	 
	 */
	public void delete(String id){
		
		CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
		CriteriaDelete<LanguageKnown> query=criteriaBuilder.createCriteriaDelete(LanguageKnown.class);
		Root<LanguageKnown> root=query.from(LanguageKnown.class);
		query.where(root.get("id").in(id));
		em.createQuery(query).executeUpdate();
		
	}

}
