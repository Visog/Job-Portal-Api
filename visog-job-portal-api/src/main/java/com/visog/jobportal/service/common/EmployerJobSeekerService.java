package com.visog.jobportal.service.common;

import java.util.List;

import com.visog.jobportal.model.common.EmployerJobSeeker;
import com.visog.jobportal.req.common.EmployerJobSeekerReq;
import com.visog.jobportal.req.common.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.EmployerJobSeekerRes;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;

public interface EmployerJobSeekerService {
	
	public void saveEmployerJobSeeker(EmployerJobSeekerReq req);

	public EmployerJobSeekerRes getEmployerJobSeeker(String Id);

	public void updateEmployerJobSeeker(EmployerJobSeekerReq req, String employerJobSeekerId);

	public Boolean deleteEmployerJobSeeker(String employerJobSeekerId);

	public List<EmployerJobSeekerRes> getEmployerJobSeeker();

	
	

}
