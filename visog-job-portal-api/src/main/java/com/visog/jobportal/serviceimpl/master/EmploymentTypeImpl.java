package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.EmploymentTypeDao;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.req.master.EmploymentTypeReq;
import com.visog.jobportal.res.master.EmploymentTypeRes;
import com.visog.jobportal.service.master.EmploymentTypeService;
import com.visog.jobportal.utils.DaoUtils;

/*
 * 
 * @author Divya Sharma
 * 
 */

public class EmploymentTypeImpl implements EmploymentTypeService {

	private static final Logger logger = Logger.getLogger(EmploymentTypeImpl.class);

	@Inject
	EmploymentTypeDao dao;

	/*
	 * 
	 * @author Divya Sharma
	 *
	 * This method saves the  employment type
	 */
	
	public void saveEmploymentType(EmploymentTypeReq req) {
		EmploymentType employment_type = new EmploymentType();
		employment_type.setName(req.getName());
		employment_type.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(employment_type);
		
		dao.save(employment_type);

		logger.info("Employment Type created successfully : " + employment_type.getId());
	}

	/*
	 * @author Divya Sharma
	 * 
	 * This method updates the employment type
	 * 
	 */
	
	public void updateEmploymentType(EmploymentTypeReq req, String employment_type_Id) {
		EmploymentType employment_type = (EmploymentType) dao.getByKey(EmploymentType.class, employment_type_Id);
		employment_type.setName(req.getName());
		employment_type.setDescription(req.getDescription());
		dao.update(employment_type);
		logger.info("Employment Type updated successfully : " + employment_type.getId());
	}

	/*
	 *  @author Divya Sharma
	 *  
	 * This method returns all the employment type
	 */
	
	public List<EmploymentTypeRes> getEmploymentType() {

		List<EmploymentType> employment_types = dao.getEmploymentType();

		List<EmploymentTypeRes> employment_typeList = new ArrayList<>();
		EmploymentTypeRes employment_typeRes = null;

		for (EmploymentType employment_type : employment_types) {
			employment_typeRes = new EmploymentTypeRes();
			employment_typeRes.setId(employment_type.getId());
			employment_typeRes.setName(employment_type.getName());
			employment_typeRes.setDescription(employment_type.getDescription());
			employment_typeList.add(employment_typeRes);
		}

		return employment_typeList;
	}

	/*
	 *  @author Divya Sharma
	 *  
	 * This method returns Role Details for the given employment type 
	 */
	
	public EmploymentTypeRes getEmploymentType(String id) {
		EmploymentType employment_type = (EmploymentType) dao.getByKey(EmploymentType.class, id);
		EmploymentTypeRes employment_typeRes = new EmploymentTypeRes();
		employment_typeRes.setId(employment_type.getId());
		employment_typeRes.setName(employment_type.getName());
		employment_typeRes.setDescription(employment_type.getDescription());
		return employment_typeRes;
	}

	/*
	 *  @author Divya Sharma
	 *  
	 * This method deletes the given employment type  
	 * 
	 */
	
	public Boolean deleteEmploymentType(String employment_typeId) {
		return (dao.delete(EmploymentType.class, employment_typeId) != 0);
		
	}

	

}
