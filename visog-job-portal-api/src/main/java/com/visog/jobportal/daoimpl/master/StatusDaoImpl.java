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
import com.visog.jobportal.dao.master.StatusDao;
import com.visog.jobportal.model.master.Status;

@Singleton
@Transactional
public class StatusDaoImpl extends AbstractDao implements StatusDao {

	private static final Logger logger = Logger.getLogger(StatusDaoImpl.class);

	/**
	 * @author Raghava This method returns the Status data
	 */

	public List<Status> getStatus() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Status> q = cb.createQuery(Status.class);
		Root<Status> c = q.from(Status.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	/**
	 * @author Raghava This method deletes the Status data
	 */

	public void delete(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<Status> query = criteriaBuilder.createCriteriaDelete(Status.class);
		Root<Status> root = query.from(Status.class);
		query.where(root.get("id").in(id));
		em.createQuery(query).executeUpdate();

	}

}
