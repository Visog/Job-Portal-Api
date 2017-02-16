package com.visog.jobportal.dao.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Users;

public interface UserDao extends AbstractDaoI {

	public List<Users> getUsers();

	public Boolean isUsersExists(String email);

	public Boolean isUsersPhoneExists(String email);

	public Boolean isUsersLoginExists(String password, String email);

	public Users getDetails(String email);

}
