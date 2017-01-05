package com.visog.jobportal.daoimpl.transaction;

import java.util.List;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.jboss.resteasy.logging.Logger;

import com.visog.jobportal.dao.AbstractDao;
import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.dao.transaction.FilesDao;
import com.visog.jobportal.model.transaction.Files;

@Singleton
@Transactional
public class FilesDaoImpl extends AbstractDao implements FilesDao {

	private static final Logger logger = Logger.getLogger(FilesDaoImpl.class);

	/**
	 * This method returns the Files data
	 * 
	 * @Author=ravi
	 */
	public List<Files> getFiles() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Files> q = cb.createQuery(Files.class);
		Root<Files> c = q.from(Files.class);
		q.select(c);
		return em.createQuery(q).getResultList();
	}

}
