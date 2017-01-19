package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.EmployerJobSeeker;


public interface EmployerJobSeekerDao extends AbstractDaoI {
	
	public List<EmployerJobSeeker> getEmployerJobSeeker();
	

}
