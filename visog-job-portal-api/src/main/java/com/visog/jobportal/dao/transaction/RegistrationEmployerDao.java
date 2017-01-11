package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.Users;

import com.visog.jobportal.dao.AbstractDaoI;

public interface RegistrationEmployerDao extends AbstractDaoI {

	public List<Users> getEmployer();

	public Boolean isEmployerExists(String email);

	public Boolean isEmployerPhoneExists(String phone);
	
	
	

}
