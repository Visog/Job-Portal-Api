package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.Users;

import com.visog.jobportal.dao.AbstractDaoI;

public interface UserDao extends AbstractDaoI {
	
	public List<Users> getUsers();
	
	public Boolean isUsersExists(String email);
	
	public Boolean isUsersPhoneExists(String email);

	public Boolean isUsersLoginExists(String password,String email);
	
	public List<Users> getIds(String password,String email);
	
}
