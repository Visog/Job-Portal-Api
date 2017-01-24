package com.visog.jobportal.service.employer;

import java.util.List;

import com.visog.jobportal.req.common.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;

public interface RegistrationEmployerService {

	public Boolean saveEmployer(UsersReq req);

	public Boolean updateEmployer(UsersReq req, String userId);

	public List<UsersRes> getEmployer();

	//public List<UsersRes> getIds(String password,String email);

	
	public UsersRes getEmployer(String id);

	public Boolean deleteEmployer(String userId);
	
	//public Boolean isUsersLoginExists(String password,String email);

}
