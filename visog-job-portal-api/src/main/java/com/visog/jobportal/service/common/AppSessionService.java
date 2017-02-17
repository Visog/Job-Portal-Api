package com.visog.jobportal.service.common;

import java.util.List;

import com.visog.jobportal.req.common.AppSessionReq;
import com.visog.jobportal.res.common.AppSessionRes;

public interface AppSessionService {
	
	public String saveAppSession(AppSessionReq req);
	
	//public List<AppSessionRes> getAppSession();

//	public AppSessionRes getAppSession(String id);

}
