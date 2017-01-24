package com.visog.jobportal.dao.jobseeker;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.jobseeker.ExperienceDetails;

public interface ExperienceDetailsDao extends AbstractDaoI{
	
	public List<ExperienceDetails> getExperienceDetails();
	


}
