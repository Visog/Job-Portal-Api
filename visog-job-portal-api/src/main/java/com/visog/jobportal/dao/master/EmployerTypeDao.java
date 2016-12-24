package com.visog.jobportal.dao.master;

import java.util.List;
import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.EmployerType;


/*
 * 
 * @author Divya Sharma
 * 
 */

public interface EmployerTypeDao extends AbstractDaoI {
	
	public List<EmployerType> getEmployerType();
	
}
