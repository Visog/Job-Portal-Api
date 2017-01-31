package com.visog.jobportal.dao.common;



import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.model.master.AddrerssType;
import com.visog.jobportal.model.master.Roles;

public interface AppCommons {

	public Roles getRoleId(String roleName);
	public AddrerssType getAddressId(String addressType);
	public Status getStatusId(String status);

}

