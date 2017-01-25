package com.visog.jobportal.service.jobseeeker;

import java.util.List;

import com.visog.jobportal.req.jobseeker.JobSeekerReq;
import com.visog.jobportal.res.common.JobSeekerRes;




public interface JobSeekerService {
	
	public void saveJObSeeker(JobSeekerReq req);

	public void updateJobSeeker(JobSeekerReq req, String jobseekerId);

	public List<JobSeekerRes> getJobSeekers();

	public JobSeekerRes getJobSeeker(String id);

	public Boolean deleteJobSeeker(String jobseekerId);
	

}
