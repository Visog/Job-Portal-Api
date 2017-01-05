package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.Users;

public interface RegistrationEmployerDao extends AbstractDaoI{
	
	public List<Users> getRegistrationEmployerDetails();

}
