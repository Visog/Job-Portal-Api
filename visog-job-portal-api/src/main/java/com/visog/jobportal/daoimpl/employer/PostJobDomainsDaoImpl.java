package com.visog.jobportal.daoimpl.employer;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.employer.PostJobDomainsDao;
import com.visog.jobportal.model.employer.PostJobDomains;


@Singleton
@Transactional
public class PostJobDomainsDaoImpl extends AbstractDao implements PostJobDomainsDao {

	private static final Logger logger = Logger.getLogger(PostJobDomainsDaoImpl.class);

	public List<PostJobDomains> getPostJobDomains() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostJobDomains> q = cb.createQuery(PostJobDomains.class);
		Root<PostJobDomains> c = q.from(PostJobDomains.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
