package com.visog.jobportal.dao.transaction;



import com.visog.jobportal.model.master.Roles;

public interface AppRoleId {

	public Roles getAdminRoleId();
	public Roles getJobSeekerRoleId();
	public Roles getEmployerRoleId();

}

