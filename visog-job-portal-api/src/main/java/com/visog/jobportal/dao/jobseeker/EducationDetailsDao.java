package com.visog.jobportal.dao.jobseeker;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.jobseeker.EducationDetails;


public interface EducationDetailsDao extends AbstractDaoI {
	
	public List<EducationDetails> getEducationDetails();
	

}

