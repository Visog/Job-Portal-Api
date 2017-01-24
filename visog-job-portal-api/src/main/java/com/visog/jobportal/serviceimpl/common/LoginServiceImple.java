package com.visog.jobportal.serviceimpl.common;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.visog.jobportal.dao.common.UserDao;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.res.transaction.UsersRes;
import com.visog.jobportal.service.common.LoginService;

public class LoginServiceImple implements LoginService {

	@Inject
	UserDao dao;
	
	
	public Boolean isUsersLoginExists(String password, String email) {
		//return null;
		if(dao.isUsersLoginExists(password, email))
		{
			return true;
		}else{
			return false;
		}

	}

	
	public UsersRes getDetails(String email){
		
		Users user = (Users) dao.getDetails(email);

		UsersRes usersRes = new UsersRes();
		usersRes.setId(user.getId());
		usersRes.setFirstName(user.getFirstName());
		usersRes.setMiddleName(user.getMiddleName());
		usersRes.setLastName(user.getLastName());
	//	Roles role=new Roles();
	//	role.setId(user.getRoleID());
	    usersRes.setRole(user.getRole().getId());
		usersRes.setEmail(user.getEmail());
		usersRes.setAlternativeEmail(user.getAlternativeEmail());
		usersRes.setGender(user.getGender().getId());
		usersRes.setDob(user.getDob());
		usersRes.setPassword(user.getPassword());
		usersRes.setPhone(user.getPhone());
		usersRes.setLandline(user.getLandline());

		return usersRes;
		
		
/*
		List<Users> users = dao.getIds(password,email);

		List<UsersRes> userList = new ArrayList<>();
		UsersRes  usersRes =null;
		
		for(Users user :  users)
		{
			usersRes = new UsersRes();
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
			userList.add(usersRes);
		}
		

		return userList;	*/
		

	}
	/*@Override
	public List<Users> getIds(String password, String email) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
