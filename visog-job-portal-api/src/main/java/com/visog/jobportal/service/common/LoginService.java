package com.visog.jobportal.service.common;

import com.visog.jobportal.res.common.UsersRes;

public interface LoginService {
	
	public Boolean isUsersLoginExists(String password, String email);

	public UsersRes getDetails(String email);

}
