package com.visog.jobportal.dao.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.EmployerJobSeeker;


public interface EmployerJobSeekerDao extends AbstractDaoI {
	
	public List<EmployerJobSeeker> getEmployerJobSeeker();
	

}
