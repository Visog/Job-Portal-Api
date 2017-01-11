package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.model.master.Roles;

public interface AppRoleId {

	public List<Roles> getJobSeekerRoleId();
	public String getEmployerRoleId();
	public String getAdminRoleId();
	}

