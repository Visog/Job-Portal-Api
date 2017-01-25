package com.visog.jobportal.service.employer;

import java.util.List;

import com.visog.jobportal.req.employer.EmployerReq;
import com.visog.jobportal.res.employer.EmployerRes;



public interface EmployerService {

	public void saveEmployer(EmployerReq req);

	public void updateEmployer(EmployerReq req, String employerId);

	public List<EmployerRes> getEmployers();

	public EmployerRes getEmployer(String id);

	public Boolean deleteEmployer(String employerId);
	
	
}
