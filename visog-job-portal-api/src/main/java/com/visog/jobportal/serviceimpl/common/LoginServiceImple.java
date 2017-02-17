package com.visog.jobportal.serviceimpl.common;

import javax.inject.Inject;

import com.visog.jobportal.dao.common.AppSessionDao;
import com.visog.jobportal.dao.common.UserDao;

import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.req.common.AppSessionReq;
import com.visog.jobportal.res.common.AppSessionRes;
import com.visog.jobportal.service.common.AppSessionService;
import com.visog.jobportal.service.common.LoginService;

public class LoginServiceImple implements LoginService {

	@Inject
	UserDao dao;
	
	@Inject
	AppSessionService appService;
	
	@Inject
	AppSessionDao appSessionDao;

	public Boolean isUsersLoginExists(String password, String email) {
		if (dao.isUsersLoginExists(password, email)) {
			
			return true;
		} else {
			return false;
		}

	}

	public AppSessionRes getDetails(String email) {

		Users user = (Users) dao.getDetails(email);
		
		AppSessionReq appSessionReq = new AppSessionReq();
		appSessionReq.setUser(user.getId());
		String sessionid=appService.saveAppSession(appSessionReq);
		
		
	
		AppSessionRes appSessionRes = new AppSessionRes();
		appSessionRes.setSessionId(sessionid);
		
		
		return appSessionRes;

	}

}
