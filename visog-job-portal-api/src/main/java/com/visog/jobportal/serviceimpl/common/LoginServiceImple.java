package com.visog.jobportal.serviceimpl.common;

import javax.inject.Inject;
import com.visog.jobportal.dao.common.UserDao;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.res.common.UsersRes;
import com.visog.jobportal.service.common.LoginService;

public class LoginServiceImple implements LoginService {

	@Inject
	UserDao dao;

	public Boolean isUsersLoginExists(String password, String email) {
		if (dao.isUsersLoginExists(password, email)) {
			return true;
		} else {
			return false;
		}

	}

	public UsersRes getDetails(String email) {

		Users user = (Users) dao.getDetails(email);
		UsersRes usersRes = new UsersRes();
		usersRes.setId(user.getId());
		usersRes.setFirstName(user.getFirstName());
		usersRes.setMiddleName(user.getMiddleName());
		usersRes.setLastName(user.getLastName());
		usersRes.setRole(user.getRole().getId());
		usersRes.setEmail(user.getEmail());
		usersRes.setAlternativeEmail(user.getAlternativeEmail());
		usersRes.setGender(user.getGender().getId());
		usersRes.setDob(user.getDob());
		usersRes.setPassword(user.getPassword());
		usersRes.setPhone(user.getPhone());
		usersRes.setLandline(user.getLandline());
		return usersRes;

	}

}
