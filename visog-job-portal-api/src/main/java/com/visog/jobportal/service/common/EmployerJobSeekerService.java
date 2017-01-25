package com.visog.jobportal.service.common;

import java.util.List;

import com.visog.jobportal.req.employer.EmployerJobSeekerReq;
import com.visog.jobportal.res.common.EmployerJobSeekerRes;



public interface EmployerJobSeekerService {
	
	public void saveEmployerJobSeeker(EmployerJobSeekerReq req);

	public EmployerJobSeekerRes getEmployerJobSeeker(String Id);

	public void updateEmployerJobSeeker(EmployerJobSeekerReq req, String employerJobSeekerId);

	public Boolean deleteEmployerJobSeeker(String employerJobSeekerId);

	public List<EmployerJobSeekerRes> getEmployerJobSeeker();

	
	

}
