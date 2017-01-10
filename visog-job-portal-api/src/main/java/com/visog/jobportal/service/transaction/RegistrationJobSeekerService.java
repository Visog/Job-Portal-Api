package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;

public interface RegistrationJobSeekerService {

	public Boolean saveJobSeeker(UsersReq req);

	public Boolean updateJobSeeker(UsersReq req, String userId);

	public List<UsersRes> getJobSeeker();

	//public List<UsersRes> getIds(String password,String email);

	
	public UsersRes getJobSeeker(String id);

	public Boolean deleteJobSeeker(String userId);
	
	//public Boolean isUsersLoginExists(String password,String email);

}
