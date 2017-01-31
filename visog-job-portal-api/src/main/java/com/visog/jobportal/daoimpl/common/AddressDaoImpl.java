package com.visog.jobportal.daoimpl.common;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.common.AddressDao;
import com.visog.jobportal.model.common.Address;



@Singleton
@Transactional
public class AddressDaoImpl extends AbstractDao implements AddressDao {
	private static final Logger logger = Logger.getLogger(AddressDaoImpl.class);

	/**
	 * This method returns the Files data
	 * 
	 * @Author=shiva
	 */
	public List<Address> getAddress() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Address> q = cb.createQuery(Address.class);
		Root<Address> c = q.from(Address.class);
		q.select(c);
		return em.createQuery(q).getResultList();

	}



	
	public Address getDataByAssociatedAddress(String addressAssociatedId) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Address> q = cb.createQuery(Address.class);
			Root<Address> c = q.from(Address.class);
			q.where(cb.equal(cb.lower(c.get("associated")), addressAssociatedId.toLowerCase()));
			q.select(c);
			return em.createQuery(q).getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
		
	}

}
