package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.JobSeekerReq;
import com.visog.jobportal.res.transaction.JobSeekerRes;



public interface JobSeekerService {
	
	public Boolean saveJObSeeker(JobSeekerReq req);

	public Boolean updateJobSeeker(JobSeekerReq req, String cityId);

	public List<JobSeekerRes> getJobSeekers();

	public JobSeekerRes getJobSeeker(String id);

	public Boolean deleteJobSeeker(String cityId);
	

}
