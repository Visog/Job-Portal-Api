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
import com.visog.jobportal.dao.master.StateDao;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.model.master.States;

@Singleton
@Transactional
public class StateDaoImpl extends AbstractDao  implements StateDao {


	private static final Logger logger = Logger.getLogger(StateDaoImpl.class);
	
	
	/**
	 * This method returns the State data
	 */
	public List<States> getStates() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<States> q = cb.createQuery(States.class);
		Root<States> c = q.from(States.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

	/*public void delete(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<States> query = criteriaBuilder.createCriteriaDelete(States.class);
		Root<States> root = query.from(States.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();

	}*/
	
	public Boolean isStateExists(String name) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		Root<States> c = q.from(States.class);
		q.where(cb.equal(cb.lower(c.get("name")), name.toLowerCase()));
		q.select(cb.count(c));
		return (em.createQuery(q).getSingleResult() != 0L);

	}

}
