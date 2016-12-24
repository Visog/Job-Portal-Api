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
import com.visog.jobportal.dao.master.AddressTypeDao;
import com.visog.jobportal.model.master.AddrerssType;

@Singleton
@Transactional
public class AddressTypeDaoImpl extends AbstractDao implements AddressTypeDao {

	private static final Logger logger = Logger.getLogger(AddressTypeDaoImpl.class);

	public List<AddrerssType> getAddressTypes() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AddrerssType> q = cb.createQuery(AddrerssType.class);
		Root<AddrerssType> c = q.from(AddrerssType.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}

	public void delete(String id) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<AddrerssType> query = criteriaBuilder.createCriteriaDelete(AddrerssType.class);
		Root<AddrerssType> root = query.from(AddrerssType.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();

	}

}
