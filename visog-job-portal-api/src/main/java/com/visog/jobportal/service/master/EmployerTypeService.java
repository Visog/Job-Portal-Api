package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.EmployerTypeReq;
import com.visog.jobportal.res.master.EmployerTypeRes;

/*
 * 
 * @author Divya Sharma
 * 
 */

public interface EmployerTypeService {
	
	public void saveEmployerType(EmployerTypeReq req);
	
	public void updateEmployerType(EmployerTypeReq req, String employer_type_Id);
	
	public List<EmployerTypeRes> getEmployerType();
	
	public EmployerTypeRes getEmployerType(String employer_type_id);
	
	public Boolean deleteEmployerType(String employer_type_Id);
	
}
