package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.Status;

public interface StatusDao extends AbstractDaoI {

	public List<Status> getStatus();
}
