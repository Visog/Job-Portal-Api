package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.ExperienceDetails;

public interface ExperienceDetailsDao extends AbstractDaoI{
	
	public List<ExperienceDetails> getExperienceDetails();
	


}
