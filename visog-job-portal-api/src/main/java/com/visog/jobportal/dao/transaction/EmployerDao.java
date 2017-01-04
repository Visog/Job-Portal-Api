package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.Employer;

public interface EmployerDao extends AbstractDaoI {

	public List<Employer> getEmployers();
}
