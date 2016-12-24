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
import com.visog.jobportal.dao.master.FileTypeDao;
import com.visog.jobportal.model.master.FileType;




@Singleton
@Transactional

/*
 * 
 * @author Divya Sharma
 * 
 */

public class FileTypeDaoImp extends AbstractDao implements FileTypeDao {

	private static final Logger logger = Logger.getLogger(FileTypeDaoImp.class);

	/**
	 * 
	 * @author Divya Sharma
	 * 
	 * This method returns the File Type data
	 * 
	 */
	public List<FileType> getFileType() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FileType> q = cb.createQuery(FileType.class);
		Root<FileType> c = q.from(FileType.class);
		q.select(c);
		return em.createQuery(q).getResultList();
		
		
	}
	
	/*
	 * 
	 * @author Divya Sharma
	 * 
	 * This method delete file type record
	 * 
	 * */
	

	public void delete(String id) {
		CriteriaBuilder criteriaBuilder  = em.getCriteriaBuilder();
		CriteriaDelete<FileType> query = criteriaBuilder.createCriteriaDelete(FileType.class);
		Root<FileType> root = query.from(FileType.class);
		query.where(root.get("id").in(id));

		em.createQuery(query).executeUpdate();
		
	}
	
	

}
