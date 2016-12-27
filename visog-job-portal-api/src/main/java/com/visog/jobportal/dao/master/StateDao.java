package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.States;

public interface StateDao extends AbstractDaoI {

	public List<States> getStates();
	
	public Boolean isStateExists(String name);
}