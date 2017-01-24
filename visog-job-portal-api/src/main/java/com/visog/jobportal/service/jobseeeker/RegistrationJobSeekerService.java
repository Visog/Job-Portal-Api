package com.visog.jobportal.service.jobseeeker;

import java.util.List;

import com.visog.jobportal.req.common.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;

public interface RegistrationJobSeekerService {

	public Boolean saveJobSeeker(UsersReq req);

	public Boolean updateJobSeeker(UsersReq req, String userId);

	public List<UsersRes> getJobSeeker();

	public UsersRes getJobSeeker(String id);

	public Boolean deleteJobSeeker(String userId);

}
