package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.ProjectDetails;

public interface ProjectDetailsDao extends AbstractDaoI{
	
	
	public List<ProjectDetails> getProjectDetails();
}
