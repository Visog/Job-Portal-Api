package com.visog.jobportal.dao.employer;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.employer.Employer;


public interface EmployerDao extends AbstractDaoI {

	public List<Employer> getEmployers();
}
