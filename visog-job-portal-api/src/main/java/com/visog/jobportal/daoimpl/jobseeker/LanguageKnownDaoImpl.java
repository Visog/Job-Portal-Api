
package com.visog.jobportal.daoimpl.jobseeker;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.jboss.resteasy.logging.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.jobseeker.LanguageKnownDao;
import com.visog.jobportal.model.jobseeker.LanguageKnown;


@Singleton
@Transactional
public class LanguageKnownDaoImpl extends AbstractDao implements LanguageKnownDao {
	private static final Logger logger = Logger.getLogger(LanguageKnownDaoImpl.class);

	/**
	 * This method returns the languageknown data
	 * 
	 * @Author=ravi
	 */
	public List<LanguageKnown> getLanguagesKnown() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<LanguageKnown> q = cb.createQuery(LanguageKnown.class);
		Root<LanguageKnown> c = q.from(LanguageKnown.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

}
