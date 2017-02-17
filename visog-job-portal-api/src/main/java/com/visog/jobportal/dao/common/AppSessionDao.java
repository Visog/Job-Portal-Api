package com.visog.jobportal.dao.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.AppSession;

public interface AppSessionDao extends AbstractDaoI {

	//public List<AppSession> getAppSession();
	public AppSession getDetails(String userid);

}
