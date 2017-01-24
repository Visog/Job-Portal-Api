package com.visog.jobportal.dao.employer;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Users;

public interface RegistrationEmployerDao extends AbstractDaoI {

	public List<Users> getEmployer();

	public Boolean isEmployerExists(String email);

	public Boolean isEmployerPhoneExists(String phone);
	
	
	

}
