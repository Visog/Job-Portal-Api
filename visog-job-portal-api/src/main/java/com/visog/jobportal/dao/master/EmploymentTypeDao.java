package com.visog.jobportal.dao.master;

import java.util.List;
import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.EmploymentType;

/*
 * 
 * @author Divya Sharma
 * 
 */

public interface EmploymentTypeDao extends AbstractDaoI {
	
	public List<EmploymentType> getEmploymentType();
	
}
