package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.EducationDetails;


public interface EducationDetailsDao extends AbstractDaoI {
	
	public List<EducationDetails> getEducationDetails();
	

}

