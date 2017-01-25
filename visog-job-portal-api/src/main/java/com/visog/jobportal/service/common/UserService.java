package com.visog.jobportal.service.common;

import java.util.List;

import com.visog.jobportal.req.common.UsersReq;
import com.visog.jobportal.res.common.UsersRes;

public interface UserService {

	public Boolean saveUsers(UsersReq req);

	public Boolean updateUsers(UsersReq req, String userId);

	public List<UsersRes> getUsers();

//	public List<UsersRes> getIds(String password,String email);

	
	public UsersRes getUsers(String id);

	public Boolean deleteUsers(String userId);
	
	//public Boolean isUsersLoginExists(String password,String email);

}
