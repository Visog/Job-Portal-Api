package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.EmployerJobSeeker;
import com.visog.jobportal.req.transaction.EmployerJobSeekerReq;
import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.EmployerJobSeekerRes;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;

public interface EmployerJobSeekerService {
	
	public void saveEmployerJobSeeker(EmployerJobSeekerReq req);

	public EmployerJobSeekerRes getEmployerJobSeeker(String Id);

	public void updateEmployerJobSeeker(EmployerJobSeekerReq req, String employerJobSeekerId);

	public Boolean deleteEmployerJobSeeker(String employerJobSeekerId);

	public List<EmployerJobSeekerRes> getEmployerJobSeeker();

	
	

}
