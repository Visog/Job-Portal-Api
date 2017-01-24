package com.visog.jobportal.dao.jobseeker;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Users;

public interface RegistrationJobSeekerDao extends AbstractDaoI {
	
	public List<Users> getJobSeeker();
	
	public Boolean isJobSeekerExists(String email);
	
	public Boolean isJobSeekerPhoneExists(String phone);

	
	
}
