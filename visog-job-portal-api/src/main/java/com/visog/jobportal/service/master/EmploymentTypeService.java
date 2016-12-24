package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.EmploymentTypeReq;
import com.visog.jobportal.res.master.EmploymentTypeRes;

/*
 * 
 * @author Divya Sharma
 * 
 */

public interface EmploymentTypeService {
	
	public void saveEmploymentType(EmploymentTypeReq req);
	
	public void updateEmploymentType(EmploymentTypeReq req, String employer_type_Id);
	
	public List<EmploymentTypeRes> getEmploymentType();
	
	public EmploymentTypeRes getEmploymentType(String employer_type_id);
	
	public Boolean deleteEmploymentType(String employer_type_Id);
	
}
