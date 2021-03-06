package com.visog.jobportal.service.admin;

import java.util.List;

import com.visog.jobportal.req.common.UsersReq;
import com.visog.jobportal.res.common.UsersRes;

public interface RegistrationAdminService {

	public Boolean saveAdmin(UsersReq req);

	public Boolean updateAdmin(UsersReq req, String adminId);

	public List<UsersRes> getAdmin();

	public UsersRes getAdmin(String id);

	public Boolean deleteAdmin(String adminId);
	

}
