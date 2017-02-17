package com.visog.jobportal.service.common;

import com.visog.jobportal.res.common.AppSessionRes;

public interface LoginService {
	
	public Boolean isUsersLoginExists(String password, String email);

	public AppSessionRes getDetails(String email);

}
