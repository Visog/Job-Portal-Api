package com.visog.jobportal.dao.admin;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Users;

public interface RegistrationAdminDao extends AbstractDaoI {
	
	public List<Users> getAdmin();
	
	public Boolean isAdminExists(String email);
	
	public Boolean isAdminPhoneExists(String phone);

	
	
}
