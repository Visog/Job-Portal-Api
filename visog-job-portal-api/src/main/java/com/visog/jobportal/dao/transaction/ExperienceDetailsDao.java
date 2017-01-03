package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.ExperienceDetails;
import com.visog.jobportal.model.transaction.Users;

public interface ExperienceDetailsDao extends AbstractDaoI{
public List<ExperienceDetails> getExperienceDetails();
	
	public Boolean isUsersExists(String email);
	
	public Boolean isUsersPhoneExists(String email);

	public Boolean isUsersLoginExists(String password,String email);
	
	public List<Users> getIds(String password,String email);
}
	