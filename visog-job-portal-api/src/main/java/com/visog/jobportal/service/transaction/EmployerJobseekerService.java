package com.visog.jobportal.service.transaction;

import java.util.List;
import com.visog.jobportal.req.transaction.EmployerJobseekerReq;
import com.visog.jobportal.res.transaction.EmployerJobseekerRes;

public interface EmployerJobseekerService {
	
	public void saveEmployerJobseeker(EmployerJobseekerReq req);
	
	public void updateEmployerJobseeker(EmployerJobseekerReq req ,String employerjobseekerId );
	
	public List<EmployerJobseekerRes> getEmployerJobseeker(String Id);
	
	public Boolean deleteEmployerJobseeker(String employerjobseekerId);
	
	

}
