package com.visog.jobportal.daoimpl.common;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.common.PostJobSeekerDao;
import com.visog.jobportal.model.common.PostJobSeeker;

@Singleton
@Transactional
public class PostJobSeekerDaoImpl extends AbstractDao implements PostJobSeekerDao {

	private static final Logger logger = Logger.getLogger(PostJobSeekerDaoImpl.class);

	public List<PostJobSeeker> getPostJobSeeker() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PostJobSeeker> q = cb.createQuery(PostJobSeeker.class);
		Root<PostJobSeeker> c = q.from(PostJobSeeker.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

}
