package com.visog.jobportal.serviceimpl.common;

import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.common.AppSessionDao;
import com.visog.jobportal.model.common.AppSession;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.req.common.AppSessionReq;
import com.visog.jobportal.res.common.AppSessionRes;
import com.visog.jobportal.service.common.AppSessionService;

public class AppSessionServiceImpl implements AppSessionService {

	private static final Logger logger = Logger.getLogger(AppSessionServiceImpl.class);

	@Inject
	AppSessionDao dao;

	public String saveAppSession(AppSessionReq req) {

		AppSession appSession = new AppSession();

		Users users = new Users();
		users.setId(req.getUser());
		appSession.setUser(users);
		appSession.setLoginDate(new Date());
		appSession.setLastHitDate(new Date());
		appSession.setSessionId(getUUID());

		dao.save(appSession);
		logger.info("AppSession created successfully : " + appSession.getSessionId());
		
		return appSession.getSessionId();
	}

	private static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/*public List<AppSessionRes> getAppSession() {
		List<AppSession> appSession = dao.getAppSession();

		List<AppSessionRes> appSessionList = new ArrayList<>();

		AppSessionRes appSessionRes = null;

		for (AppSession appSessions : appSession) {

			appSessionRes = new AppSessionRes();

			appSessionRes.setSessionId(appSessions.getSessionId());

			appSessionRes.setUser(appSessions.getUser().getId());
			appSessionRes.setLoginDate(appSessions.getLoginDate());

			appSessionRes.setLogoutDate(appSessions.getLogoutDate());

			appSessionRes.setLastHitDate(appSessions.getLastHitDate());

		}

		return appSessionList;
	}*/

	/*public AppSessionRes getAppSession(String id) {
		AppSession appSession = (AppSession) dao.getByKey(AppSession.class, id);

		AppSessionRes appSessionRes = new AppSessionRes();

		appSessionRes.setSessionId(appSession.getSessionId());

		appSessionRes.setUser(appSession.getUser().getId());
		appSessionRes.setLoginDate(appSession.getLoginDate());

		appSessionRes.setLogoutDate(appSession.getLogoutDate());
		appSessionRes.setLastHitDate(appSession.getLastHitDate());

		return appSessionRes;
	}
*/
}
