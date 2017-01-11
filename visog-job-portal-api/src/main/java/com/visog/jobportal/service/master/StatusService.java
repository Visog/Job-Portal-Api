package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.StatusReq;
import com.visog.jobportal.res.master.StatusRes;

public interface StatusService {

	public void saveStatus(StatusReq req);

	public void updateStatus(StatusReq req, String statusId);

	public List<StatusRes> getStatus();

	public StatusRes getStatus(String id);

	public Boolean deleteStatus(String statusId);

}
