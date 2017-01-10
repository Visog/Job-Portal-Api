package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.Users;

import com.visog.jobportal.dao.AbstractDaoI;

public interface RegistrationJobSeekerDao extends AbstractDaoI {
	
	public List<Users> getJobSeeker();
	
	public Boolean isJobSeekerExists(String email);
	
	public Boolean isJobSeekerPhoneExists(String email);

	//public Boolean isUsersLoginExists(String password,String email);
	
	//public List<Users> getIds(String password,String email);
	
}