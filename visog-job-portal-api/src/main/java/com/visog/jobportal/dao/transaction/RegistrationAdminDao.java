package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.Users;

import com.visog.jobportal.dao.AbstractDaoI;

public interface RegistrationAdminDao extends AbstractDaoI {
	
	public List<Users> getAdmin();
	
	public Boolean isAdminExists(String email);
	
	public Boolean isAdminPhoneExists(String phone);

	
	
}
