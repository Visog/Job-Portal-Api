package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.EmployerJobseeker;


public interface EmployerJobseekerDao extends AbstractDaoI {
	
	public List<EmployerJobseeker> getEmployerjobseekers();
	

}
