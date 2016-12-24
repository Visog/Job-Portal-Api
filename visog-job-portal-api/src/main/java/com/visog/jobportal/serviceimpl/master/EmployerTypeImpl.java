package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.visog.jobportal.dao.master.EmployerTypeDao;
import com.visog.jobportal.model.master.EmployerType;
import com.visog.jobportal.req.master.EmployerTypeReq;
import com.visog.jobportal.res.master.EmployerTypeRes;
import com.visog.jobportal.service.master.EmployerTypeService;
import com.visog.jobportal.utils.DaoUtils;

/*
 * 
 * @author Divya Sharma
 * 
 */

public class EmployerTypeImpl implements EmployerTypeService {

	private static final Logger logger = Logger.getLogger(EmployerTypeImpl.class);

	@Inject
	EmployerTypeDao dao;

	/*
	 * @author Divya Sharma
	 * 
 	 * This method saves the Employer Type  
	 */
	
	public void saveEmployerType(EmployerTypeReq req) {
		EmployerType employer_type = new EmployerType();
		employer_type.setName(req.getName());
		employer_type.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(employer_type);
		
		dao.save(employer_type);

		logger.info("Employer Type created successfully : " + employer_type.getId());
	}

	/*
	 * 
	 * @author Divya Sharma
     * 
	 * This method updates the Employer Type  
	 */
	public void updateEmployerType(EmployerTypeReq req, String employer_type_Id) {
		EmployerType employer_type = (EmployerType) dao.getByKey(EmployerType.class, employer_type_Id);
		employer_type.setName(req.getName());
		employer_type.setDescription(req.getDescription());
		dao.update(employer_type);
		logger.info("Employer Type updated successfully : " + employer_type.getId());
	}

	/*
	 * 
	 * @author Divya Sharma
	 * 
     * This method returns all the Employer Type  
	 */
	public List<EmployerTypeRes> getEmployerType() {

		List<EmployerType> employer_types = dao.getEmployerType();

		List<EmployerTypeRes> employer_typeList = new ArrayList<>();
		EmployerTypeRes employer_typeRes = null;

		for (EmployerType employer_type : employer_types) {
			employer_typeRes = new EmployerTypeRes();
			employer_typeRes.setId(employer_type.getId());
			employer_typeRes.setName(employer_type.getName());
			employer_typeRes.setDescription(employer_type.getDescription());
			employer_typeList.add(employer_typeRes);
		}

		return employer_typeList;
	}

	/*
	 * 
	 * @author Divya Sharma
	 * 
 	 * This method returns Employer Type   Details for the given Employer Type   
	 */
	
	public EmployerTypeRes getEmployerType(String id) {
		EmployerType employer_type = (EmployerType) dao.getByKey(EmployerType.class, id);
		EmployerTypeRes employer_typeRes = new EmployerTypeRes();
		employer_typeRes.setId(employer_type.getId());
		employer_typeRes.setName(employer_type.getName());
		employer_typeRes.setDescription(employer_type.getDescription());
		return employer_typeRes;
	}

	/*
	 * 
	 * @author Divya Sharma
	 *   
	 * This method deletes the given Employer Type  
	 */
	
	public Boolean deleteEmployerType(String employer_typeId) {
		return (dao.delete(EmployerType.class, employer_typeId) != 0);
		
	}

	

}
