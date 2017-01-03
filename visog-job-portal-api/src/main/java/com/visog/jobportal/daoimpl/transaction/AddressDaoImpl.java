package com.visog.jobportal.daoimpl.transaction;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.transaction.AddressDao;
import com.visog.jobportal.model.transaction.Address;


@Singleton
@Transactional

public class AddressDaoImpl extends AbstractDao implements AddressDao{
	private static final Logger logger = Logger.getLogger(AddressDaoImpl.class);
	
	public List<Address> getAddress() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Address> q = cb.createQuery(Address.class);
		Root<Address> c = q.from(Address.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
		
	}
	
	

}
